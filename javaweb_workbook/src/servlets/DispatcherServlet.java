package servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bind.DataBinding;
import bind.ServletRequestDataBinder;
import context.ApplicationContext;
import controls.Controller;
import listeners.ContextLoaderListener;

@SuppressWarnings("serial")
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");
    String servletPath = request.getServletPath();
    try {
      ApplicationContext ctx = ContextLoaderListener.getApplicationContext();
      
      HashMap<String,Object> model = new HashMap<String,Object>();
      model.put("session", request.getSession());
      
      Controller pageController = (Controller) ctx.getBean(servletPath);
      if (pageController == null) {
        throw new Exception("�슂泥��븳 �꽌鍮꾩뒪瑜� 李얠쓣 �닔 �뾾�뒿�땲�떎.");
      }
      
      if (pageController instanceof DataBinding) {
        prepareRequestData(request, model, (DataBinding)pageController);
      }

      // �럹�씠吏� 而⑦듃濡ㅻ윭瑜� �떎�뻾�븳�떎.
      String viewUrl = pageController.execute(model);
      
      // Map 媛앹껜�뿉 ���옣�맂 媛믪쓣 ServletRequest�뿉 蹂듭궗�븳�떎.
      for (String key : model.keySet()) {
        request.setAttribute(key, model.get(key));
      }
      
      if (viewUrl.startsWith("redirect:")) {
        response.sendRedirect(viewUrl.substring(9));
        return;
      } else {
        RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
        rd.include(request, response);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      rd.forward(request, response);
    }
  }

  private void prepareRequestData(HttpServletRequest request,
      HashMap<String, Object> model, DataBinding dataBinding)
      throws Exception {
    Object[] dataBinders = dataBinding.getDataBinders();
    String dataName = null;
    Class<?> dataType = null;
    Object dataObj = null;
    for (int i = 0; i < dataBinders.length; i+=2) {
      dataName = (String)dataBinders[i];
      dataType = (Class<?>) dataBinders[i+1];
      dataObj = ServletRequestDataBinder.bind(request, dataType, dataName);
      model.put(dataName, dataObj);
    }
  }
}

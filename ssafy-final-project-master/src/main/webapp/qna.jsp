<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <link rel="icon" href="/favicon.ico" />
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <meta name="theme-color" content="#000000" />
    <meta
      name="description"
      content="Web site created using create-react-app"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
    />
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="apple-touch-icon" href="dist/logo192.png" />
    <link rel="manifest" href="dist/manifest.json" />
    <title>React App</title>
    <link href="dist/static/css/main.b100e6da.chunk.css" rel="stylesheet" />
    <link type="text/css" href="css/css.css" rel="stylesheet" />
  </head>
  <body>
    <noscript>You need to enable JavaScript to run this app.</noscript>
    <jsp:include page="header.jsp"></jsp:include>
    <div id="root"></div>
    <script>
      !(function(i) {
        function e(e) {
          for (
            var r, t, n = e[0], o = e[1], u = e[2], l = 0, f = [];
            l < n.length;
            l++
          )
            (t = n[l]),
              Object.prototype.hasOwnProperty.call(p, t) &&
                p[t] &&
                f.push(p[t][0]),
              (p[t] = 0);
          for (r in o)
            Object.prototype.hasOwnProperty.call(o, r) && (i[r] = o[r]);
          for (s && s(e); f.length; ) f.shift()();
          return c.push.apply(c, u || []), a();
        }
        function a() {
          for (var e, r = 0; r < c.length; r++) {
            for (var t = c[r], n = !0, o = 1; o < t.length; o++) {
              var u = t[o];
              0 !== p[u] && (n = !1);
            }
            n && (c.splice(r--, 1), (e = l((l.s = t[0]))));
          }
          return e;
        }
        var t = {},
          p = { 1: 0 },
          c = [];
        function l(e) {
          if (t[e]) return t[e].exports;
          var r = (t[e] = { i: e, l: !1, exports: {} });
          return i[e].call(r.exports, r, r.exports, l), (r.l = !0), r.exports;
        }
        (l.m = i),
          (l.c = t),
          (l.d = function(e, r, t) {
            l.o(e, r) ||
              Object.defineProperty(e, r, { enumerable: !0, get: t });
          }),
          (l.r = function(e) {
            "undefined" != typeof Symbol &&
              Symbol.toStringTag &&
              Object.defineProperty(e, Symbol.toStringTag, { value: "Module" }),
              Object.defineProperty(e, "__esModule", { value: !0 });
          }),
          (l.t = function(r, e) {
            if ((1 & e && (r = l(r)), 8 & e)) return r;
            if (4 & e && "object" == typeof r && r && r.__esModule) return r;
            var t = Object.create(null);
            if (
              (l.r(t),
              Object.defineProperty(t, "default", { enumerable: !0, value: r }),
              2 & e && "string" != typeof r)
            )
              for (var n in r)
                l.d(
                  t,
                  n,
                  function(e) {
                    return r[e];
                  }.bind(null, n)
                );
            return t;
          }),
          (l.n = function(e) {
            var r =
              e && e.__esModule
                ? function() {
                    return e.default;
                  }
                : function() {
                    return e;
                  };
            return l.d(r, "a", r), r;
          }),
          (l.o = function(e, r) {
            return Object.prototype.hasOwnProperty.call(e, r);
          }),
          (l.p = "/");
        var r = (this["webpackJsonpfinal-project"] =
            this["webpackJsonpfinal-project"] || []),
          n = r.push.bind(r);
        (r.push = e), (r = r.slice());
        for (var o = 0; o < r.length; o++) e(r[o]);
        var s = n;
        a();
      })([]);
    </script>
    <script src="dist/static/js/2.405b7c5a.chunk.js"></script>
    <script src="dist/static/js/main.3946c872.chunk.js"></script>
    <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>

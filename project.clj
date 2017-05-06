(defproject solasistim/rook-middleware-access-rules "0.1.2-SNAPSHOT"
  :description
  "access rule support for authorization of Rook endpoint handlers, using buddy-auth"
  :url "http://github.com/amoe/rook-middleware-access-rules"
  :license {:name "LGPLv3"
            :url "https://www.gnu.org/licenses/lgpl-3.0.en.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [io.aviso/rook "0.1.39"]
                 [buddy/buddy-auth "1.4.1"]
                 [ring/ring-mock "0.3.0"]
                 [ring/ring-core "1.6.0"]])


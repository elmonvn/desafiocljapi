(defproject desafiocljapi "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [org.clojure/java.jdbc "0.7.10"]
                 [org.xerial/sqlite-jdbc "3.7.2"]
                 [ring/ring-json "0.5.0"]
                 [ring-basic-authentication "1.0.5"]
                 ]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler desafiocljapi.handler/app}
  :target-path "target/%s"
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}
   :uberjar {:aot :all}
   }
  )

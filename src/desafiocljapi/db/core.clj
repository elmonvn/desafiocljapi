(ns desafiocljapi.db.core
  (:require [clojure.java.jdbc :as jdbc]
            ;[desafiocljapi.db.queries]
            )
  )

(def db-spec {:dbtype "sqlite"
              :dbname (str (System/getProperty "user.dir") "/resources/db/desafiocljapi.db")
              }
  )

(ns desafiocljapi.db.queries
  (:require [desafiocljapi.db.core :refer :all]
            [clojure.java.jdbc :as jdbc]
            )
  )

(defn auth-user
  [usrname passwd]
  (let [res (jdbc/query db-spec ["select u.id from auth as a, users as u where u.screen_name=? and u.id=a.userid and a.password=?" usrname passwd])]
    ;(reset! userid (get (mapv (first res) [:id]) 0))
    (if (empty? res)
      (not (empty? res))
      (get (mapv (first res) [:id]) 0)
      )
    )
  )

(defn get-userid
  [usrname passwd]
  (let [res (jdbc/query db-spec ["select u.id from auth as a, users as u where u.screen_name=? and u.id=a.userid and a.password=?" usrname passwd])]
    (get (mapv (first res) [:id]) 0)
    )
  )

(defn update-status
  [user text]
  (jdbc/insert! db-spec :tweets {:user user :text text})
  )

(defn lookup-status [user text]
  (jdbc/insert! db-spec :tweets {:user user :text text})
  )

(defn show-status [user text]
  (jdbc/insert! db-spec :tweets {:user user :text text})
  )

(defn create-user [user text]
  (jdbc/insert! db-spec :tweets {:user user :text text})
  )

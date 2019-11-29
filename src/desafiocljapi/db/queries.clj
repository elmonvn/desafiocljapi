(ns desafiocljapi.db.queries
  (:require [desafiocljapi.db.core :refer :all]
            [clojure.java.jdbc :as jdbc]
            )
  )

(defn auth-user
  [usrname passwd]
  (let [res (jdbc/query db-spec ["select u.id from auth as a, users as u where u.screen_name=? and u.id=a.userid and a.password=?" usrname passwd])]
    (if (empty? res)
      (not (empty? res))
      (get (mapv (first res) [:id]) 0)
      )
    )
  )
(comment
(defn get-userid
  [user]
  (let [res (jdbc/query db-spec ["select id from users where screen_name=?" user])]
    (get (mapv (first res) [:id]) 0)
    )
  ))

(defn update-status
  [user text]
  (jdbc/insert! db-spec :tweets {:user user :text text})
  )

(defn lookup-status [user]
  (let [res (jdbc/query db-spec ["select * from tweets where user=?" user])]
    ;(println res)
    (println ((mapv (res) [:user])))
    )
  )
;(lookup-status 1)

(defn show-status [user text]
  (jdbc/insert! db-spec :tweets {:user user :text text})
  )

(defn create-user [user text]
  (jdbc/insert! db-spec :tweets {:user user :text text})
  )

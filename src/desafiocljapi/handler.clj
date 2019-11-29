(ns desafiocljapi.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.basic-authentication :refer [wrap-basic-authentication]]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]
            [desafiocljapi.db.queries :refer :all]
            )
  )

(defn authenticated?
  [name pass]
  (auth-user name pass)
  )

(defroutes app-routes
  (GET "/" [] "Hello World")
  
  (POST "/statuses/update" {:keys [params]} ; postar tweet
    (let [{:keys [userid text]} params]
      (response (update-status 1 text))))
  
  (GET "/statuses/lookup" [uid]
       (response (lookup-status uid))) ;
  
  (GET "/statuses/show/:id" [tweetid]
       (response (show-status (Integer/parseInt tweetid))))
  
  (POST "/user/create" {:keys [params]} ; criar novo usuário (apenas para Admin)
    (let [{:keys [username passwd]} params]
      (response (create-user username passwd))))
  
  (route/not-found "Not Found")
  )

(def app
  (->
    (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false))
    (wrap-basic-authentication authenticated?)
    (wrap-json-response)
    )
  )

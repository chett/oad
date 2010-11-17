(ns myproject.core
  (:use compojure.core)
  (:require [compojure.route :as route]))

(defroutes example
  (GET "/" [] "<h1>hello, world!</h1>")
  (route/not-found "Page not found"))
(defroutes example-uid
  (GET "/user/:id" [id] (str "<h1> Hello, " id " </h1>")))


;; TODO wts
;; (defn mkstr [id]
;;   str "Mr/Ms" id)
;; (defn addheader [s]
;;   (str "<h1>" s))
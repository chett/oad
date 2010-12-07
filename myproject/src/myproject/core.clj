(ns myproject.core
  (:use compojure.core)
  (:require [compojure.route :as route]))

(defroutes example
  (GET "/" [] "<h1>hello, world!</h1>")
  (route/not-found "Page not found"))
(defroutes example-uid
  (GET "/user/:id" [id] (str "<h1> Hello, " id " </h1>")))

(defn testfn [x]
  98)
(defn testfn2 [x]
  (* x x))
(defn testfn3 [x]
  (* x x))
(defn testfn4 [x]
  (* x x x))
(defn testfn5 [x]
  (* x x x x x))
;; TODO wts
;; (defn mkstr [id]
;;   str "Mr/Ms" id)
;; (defn addheader [s]
;;   (str "<h1>" s))
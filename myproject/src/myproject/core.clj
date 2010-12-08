(ns myproject.core
  (:use compojure.core)
  (:require [compojure.route :as route]))

(defroutes example
  (GET "/" [] "<h1>hello, world!</h1>")
  (route/not-found "Page not found"))
(defroutes example-uid
  (GET "/user/:id" [id] (str "<h1> Hello, " id " </h1>")))

(defn add-title [id]
  "prepend Mr/Ms"
  (str "Mr/Ms " id))

(defn wrap-tag [val tag]
  "wraps val in html tag"
  (str (open-tag tag) val (close-tag tag)))

(defn open-tag [tag]
  "creates opening html tag"
  (str "<" (.toLowerCase tag) ">"))

(defn close-tag [tag]
  "creates closing html tag"
  (str "</" (.toLowerCase tag) ">"))
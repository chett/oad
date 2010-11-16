(ns myproject.core
  (:use compojure.core)
  (:require [compojure.route :as route]))

(defroutes example
  (GET "/" [] "<h1>hello, world!</h1>")
  (route/not-found "Page not found"))

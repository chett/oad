(ns myproject.core
  (:use compojure.core, ring.adapter.jetty)
  (:require [compojure.route :as route]))

(def first-names (ref #{}))

(def middle-names (ref #{}))

(def last-name "")

(defn contains-name? [n names]
  (some true? (map #(.equalsIgnoreCase % n) names)))

;; (defn get-tbl-rows []
;;   (str first-names middle-names last-name))

(defn get-tbl-rows []
  (let [result []]
    (for [first [@first-names]]
      (for [middle [conj @first-names @middle-names]]
	(do (println first middle)
	(set result (cons (wrap-tag (str first middle last-name) "tr") result)))))
    result))

(defn make-three-part-names []
  (str "<tr><th>first</th><th>middle</th><th>last</th></tr>"
       (get-tbl-rows)))

(defn make-name-table[]
  (wrap-tag (make-three-part-names) "table"))

(defroutes my-name-app
  (GET "/add/first/:name" [name]
       (do
	 (if (not (contains-name? name @first-names)) (dosync(alter first-names conj (str name))))
	 (str "<h1>added first-name " name "</h1>")))
  (GET "/remove/first/:name" [name]
       (do
	 (dosync(ref-set first-names (remove #(.equalsIgnoreCase name %) @first-names)))
	 (str "<h1>removed first-name" name "</h1>")))
  (GET "/add/middle/:name" [name]
       (do
	 (if (not (contains-name? name @middle-names)) (dosync(alter middle-names conj (str name))))
	 (str "<h1>added middle-name" name "</h1>")))
  (GET "/remove/middle/:name" [name]
       (do
	 (dosync(ref-set middle-names (remove #(.equalsIgnoreCase name %) @middle-names)))
	 (str "<h1>removed middle-name" name "</h1>")))
  (GET "/set/last/:name" [name]
       (do
	 (dosync (ref-set last-name (str name)))
	 (str "<h1>added middle-name" name "</h1>")))
  (GET "/show/" []
       (str "<h1>names</h1>"
	    (make-name-table)))
  (ANY "*" []
       "page-not-found"))

(defn open-tag [tag]
  "creates opening html tag"
  (str "<" (.toLowerCase tag) ">"))

(defn close-tag [tag]
  "creates closing html tag",
  (str "</" (.toLowerCase tag) ">"))

(defn wrap-tag [val tag]
  "wraps val in html tag"
  (str (open-tag tag) val (close-tag tag)))

(run-jetty my-name-app {:port 8080})
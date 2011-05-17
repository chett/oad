;; Programming Clojure Chapter 3 examples
;; 12-28-2010
(ns myproject.ch3
  (:use [clojure.contrib.repl-utils :only [show]]
	[org.xml.sax InputSource]
	[org.xml.sax.helpers DefaultHandler]
	[java.io StringReader]
	[javax.xml.parsers SAXParserFactory])
  (:import (java.util Date)))

(def rnd (new java.util.Random))

(defn now []
  (new Date))

(defn pita []
  (let [a (make-array String 3)]
    (aset a 0 "Zero")
    (aset a 1 "One")
    (aset a 2 "Two")))

(defn slow-sum [n]
  (let [n n]
    (loop [i 1 sum 0]
      (if (<= i n)
	(recur (inc i) ( + i sum))
	sum))))

(defn best-sum [n]
  (/ (* n (inc n)) 2))

(def print-element-handler
     (proxy [DefaultHandler] []
       (startElement
	[uri local qname atts]
	(println (format "Saw elt: %s" qname)))))
	
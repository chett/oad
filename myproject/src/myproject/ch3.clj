;; Programming Clojure Chapter 3 examples
;; 12-28-2010
(ns myproject.ch3
  (:use [clojure.contrib.repl-utils :only [show]])
  (:import (java.util Date)))

(def rnd (new java.util.Random))

(defn now []
  (new Date))
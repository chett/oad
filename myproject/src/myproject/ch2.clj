;; Programming Clojure Chapter 1 examples
;; 12-28-2010
(ns myproject.ch2)

(defn encode [x]
  (apply str (apply interleave x)))

(defn argfn [z & q]
  (apply str z q))
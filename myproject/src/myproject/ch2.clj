;; Programming Clojure Chapter 2 examples
;; 12-28-2010
(ns myproject.ch2
  (:use [clojure.contrib.str-utils :only (re-split)]))

(defn encode [x]
  (apply str (apply interleave x)))

(defn argfn [z & q]
  (apply str z q))
(def inventors {:Lisp "McCarthy", :Clojure "Hickey"})
(defstruct book :title :author)

(defn hello-arity
  ([] (hello-arity "world"))
  ([x] (str "Hello, " x)))

(defn indexable-word? [x]
  (> (count x) 2))



(defn long-filter []
  (filter indexable-word?
	  (re-split #"\W" "A quick fox jumped over a brown  dog")))

(defn indexable-words [text]
  (let [indexable-word? (fn [w] (> (count w) 2))
	split-on-whitespace (fn [s] (re-split #"\W+" s))]
    (filter indexable-word? (split-on-whitespace text))))

(defn make-greeter [greeting-prefix]
  #(str greeting-prefix ", " %))

(defn square-corners [bottom left size]
  (let [top (+ bottom size)
	right (+ left size)]
    [[bottom left] [top left] [top right] [bottom right]]))

(defstruct author :last-name :first-name)

(defn hiya [{a :first-name}]
  (str "hiya, " a))

(defn indexed [coll]
  (map vector (iterate inc 0) coll))

(defn index-filter [pred coll]
  (when pred
    (for [[idx elt] (indexed coll) :when (pred elt)] idx)))


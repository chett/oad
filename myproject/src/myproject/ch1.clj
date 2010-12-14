;; Programming Clojure Chapter 1 examples
;; 11-25-2010
(ns myproject.ch1)

(defn hello [username]
  "prints hello, username"
  (println "hello, " username))

(defn goodbye [username]
  "prints goodbye, username"
  (str "goodbye, " username))
	
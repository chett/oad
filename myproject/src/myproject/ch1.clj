;; Programming Clojure Chapter 1 examples
;; 11-25-2010
(ns myproject.ch1)

(defn hello [username]
  "prints hello, username"
  (println "hello, " username))

(defn goodbye [username]
  "prints goodbye, username"
  (str "goodbye, " username))

(defn blank? [s]
  "is every character blank"
  (every? #(Character/isWhitespace %) s))

;;pg 16
(def visitors (ref #{}))
(defn hello-visitor [name]
  (dosync
   (let [past-visitor (@visitors name)]
     (if past-visitor
       (str "hello again, " name)
       (do
	 (alter visitors conj name)
	 (str "hello, " name))))))
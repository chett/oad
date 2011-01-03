(ns myproject.test.ch2test
  (:use [myproject.ch2] :reload)
  (:use [clojure.test])
  (:use [clojure.contrib.str-utils :only (re-split)]))

;;pg 31
(deftest encode-test
  (is (= (encode ["xxx" "yyy" "zzz"])
	 "xyzxyzxyz")))

;;pg 37
(deftest hello-arity-test
  (is (.equals "Hello, world" (hello-arity))))

;;pg 38
(deftest filter-test
  (is (= (long-filter)
	 (filter (fn [w] (> (count w) 2))
		 (re-split #"\W" "A quick fox jumped over a brown  dog")))))
;;pg 39
(deftest filter-test-2
  (is (= (filter #(> (count %) 2)
		 (re-split #"\W" "A quick fox jumped over a brown  dog"))
	 (long-filter)
	 (indexable-words "A quick fox jumped over a brown  dog"))))

;;pg 40
(deftest greeter-test
  (let [hawaiian-greeter (make-greeter "Aloha")]
    (is (= (hawaiian-greeter "ted")
	   "Aloha, ted"))))

;; pg 42
(deftest square-corners-test
  (is (= [[0 0] [1 0] [1 1] [0 1]]
	   (square-corners 0 0 1))))

;; destructuring
(deftest hiya-test
  (is (= "hiya, t"
	 (hiya (struct author "c" "t")))))

(deftest ds-test
  (let [[_ _ z] [1 2 3]
	a (:first-name (struct author "t" "chet"))]
    (is (= a "chet"))
    (is (= _ 2))
    (is (= z 3))))

;; namespaces
(deftest ns-test
  (is (= #'myproject.ch2/author
	 (resolve 'author))))

(import '(java.io InputStream File))
(deftest file-sep-test
  (is (= "/"
	 File/separator)))
	

	
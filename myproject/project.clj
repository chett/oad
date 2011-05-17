(defproject myproject "1.0.0-SNAPSHOT"
  :description "Programming Clojure examples"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
		 [compojure "0.5.2"]
		 [ring/ring-jetty-adapter "0.3.1"]]
  :dev-dependencies[[swank-clojure "1.2.0"]
		    [autodoc "0.7.1" :exclusions [org.clojure/clojure-contrib
						  org.clojure/clojuren]]])
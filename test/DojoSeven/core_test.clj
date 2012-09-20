(ns DojoSeven.core-test
  (:use clojure.test
        DojoSeven.core))

(def something "
    _  _     _  _  _  _  _ 
  | _| _||_||_ |_   ||_||_|
  ||_  _|  | _||_|  ||_| _|
")

(def different "
    _  _  _  _  _  _     _ 
|_||_|| ||_||_   |  |  ||_ 
  | _||_||_||_|  |  |  | _|
") 

(def one
"
   
  |
  |
")

(def two
"
 _ 
 _|
|_ 
")

(def three
"
 _ 
 _|
 _|
")

(def five
"
 _ 
|_ 
 _|
")

(deftest multilinestring
    (is (= (str "\n" " _ \n" "|_ \n" " _|\n") five)))

(deftest splitinputtest
	(is (= [" _ ", "|_ ", " _|"]
		(split-input five)))
	(is (= [" _ ", " _|", " _|"]
		(split-input three)))
	(is (= ["   ", "  |", "  |"]
		(split-input one))))

(deftest strip-newlinestest
	(is (= [
	      \space \space \space
	      \space \space \|
	      \space \space \|] (strip-newlines one)))
	(is (= [
	      \space \_     \space
	      \|     \_     \space
	      \space \_     \|] (strip-newlines five))))


(deftest getlettertest
	(is (= (strip-newlines one) (first (get-digits something))))
    (is (= (strip-newlines two) (second (get-digits something))))
    (is (= (strip-newlines five) (nth (get-digits something) 4))))

(deftest valueofdigittest
	(is (= 5 (parse-digit (strip-newlines five))))
	(is (= 2 (parse-digit (strip-newlines two)))))

(deftest listnumberstonumber
	(is (= "123" (makestr [1 2 3]))))

(deftest were-done 
	(is (= "123456789"
		 (recognize something)))
	(is (= "490867715" 
		 (recognize different))))

(ns DojoSeven.core
 (:require [clojure.string :as string]) 
 (:require [clojure.pprint :as pretty]))


(def nums "
 _     _  _     _  _  _  _  _ 
| |  | _| _||_||_ |_   ||_||_|
|_|  ||_  _|  | _||_|  ||_| _|
")


(defn split-input [input]
	(rest (string/split-lines input)))

(defn strip-newlines [a-string]
	(map identity (string/replace a-string #"\n" "")))

(defn get-digits [input]
	(let [
		lines (split-input input)
		partial-token-lists (map (fn [n] (partition 3 n)) lines)
		tokens (apply (partial map concat) partial-token-lists)]
		tokens
	))

(defn parse-digit [digit]
	(let 
		[alldigits (get-digits nums)]
		(.indexOf alldigits digit) 
	))

(defn makestr [listofdigits]
  (apply str listofdigits))

(defn recognize [string]
	(makestr (map parse-digit (get-digits string))))


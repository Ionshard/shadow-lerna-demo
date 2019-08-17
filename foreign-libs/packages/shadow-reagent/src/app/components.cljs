(ns app.components
  (:require [reagent.core :as r]
            ["jump-scare-component" :default jump-scare-component]))

(def jump-scare (r/adapt-react-class jump-scare-component))

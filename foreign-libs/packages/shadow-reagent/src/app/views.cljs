(ns app.views
  (:require [app.state :refer [app-state]]
            [app.events :refer [increment decrement]]
            [app.components :as c]))

(defn header
  []
  [:div
   [c/jump-scare]
   [:h1 "A template for reagent apps"]])

(defn counter
  []
  [:div
   [:button.btn {:on-click #(decrement %)} "-"]
   [:button {:disabled true} (get @app-state :count)]
   [:button.btn {:on-click #(increment %)} "+"]])

(defn app []
  [:div
   [header]
   [counter]])

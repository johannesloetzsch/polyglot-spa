(ns polyglot-spa.views
  (:require [reagent.core :as r]
            [re-com.core :as re-com]
            [clojure.string :as string]))

(defn menu
  "react component showing a popup-menu with the entries of the routes routes created by page->routes"
  [routes]
  (let [showing? (r/atom false)]
       [re-com/popover-anchor-wrapper
       :showing? showing?
       :position :below-right
       :anchor [re-com/md-icon-button
                :md-icon-name "zmdi-menu"
                :on-click #(swap! showing? not)]
       :popover [re-com/popover-content-wrapper
                 :body [:div (for [[id {:keys [menuentry]}] routes]
                                  [:p {:key (str "menuitem_" (string/replace id #"[^a-z]" ""))}
                                      [:a {:onClick #(reset! showing? false)
                                           :href (str "#" id)}
                                          menuentry]])]
                 :arrow-width 0
                 :arrow-length 0]]))

(defn menu-left [routes]
  [re-com/v-box
   :height "100%"
   :children [[re-com/h-box
               :width "100%"
               :children [[menu routes]]]]])

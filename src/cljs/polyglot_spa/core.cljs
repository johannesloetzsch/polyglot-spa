(ns polyglot-spa.core
  (:require
   [reagent.core :as reagent]
   [polyglot-spa.views :as views]
   [reitit.frontend :as rf]
   [reitit.frontend.easy :as rfe]
   [reitit.coercion.spec :as rss]
   [dommy.core :as dommy :refer-macros [sel]]))

(defn page->routes
  "calculate routes from page classes"
  []
  (map #(vector (dommy/attr % :id)
                {:menuentry (dommy/attr % :menuentry)})
       (dommy/sel ".page")))


(defn browse
  "set only one page visible (used by router)"
  [page]
  (doall (map #(dommy/set-style! % :display "none")
              (sel ".page")))
  (if-let [elem (.getElementById js/document page)]
          (dommy/remove-style! elem :display)))


(defn ^:dev/after-load mount-root []
  (let [routes (page->routes)]
       (rfe/start!
         (rf/router routes {:data {:coercion rss/coercion}})
         (fn [match] (browse (:template match (first (first routes)))))
         {:use-fragment true})
       #_(re-frame/clear-subscription-cache!)
       (reagent/render [views/menu-left routes]
                       (.getElementById js/document "menu"))))

(defn init []
  (mount-root))

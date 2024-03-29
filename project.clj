(defproject polyglot-spa "0.1.0"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}

  :min-lein-version "2.5.3"
  :source-paths ["src/clj" "src/cljs"]
  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.520"
                  :exclusions [com.google.javascript/closure-compiler-unshaded
                               org.clojure/google-closure-library]]
                 [thheller/shadow-cljs "2.8.52"]
                 [reagent "0.8.1"]
                 [re-frame "0.10.9"]
                 [re-com "2.5.0"]
                 [metosin/reitit "0.3.9"]
                 [metosin/reitit-frontend "0.3.9"]
                 [prismatic/dommy "1.1.0"]]

  :profiles {:dev {:dependencies [[binaryage/devtools "0.9.10"]]}
             :prod {}}

  :aliases {"dev"  ["with-profile" "dev" "run" "-m" "shadow.cljs.devtools.cli" "watch" "app"]
            "prod" ["with-profile" "prod" "run" "-m" "shadow.cljs.devtools.cli" "release" "app"]})

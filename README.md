# polyglot-spa

A simple script to help you build SinglePageApplications, that expect JavaScript but also work when JavaScript is disabled.

[![CircleCI](https://img.shields.io/circleci/project/github/johannesloetzsch/polyglot-spa.svg?label=tests)](https://circleci.com/gh/johannesloetzsch/polyglot-spa)
[![Clojars Project](https://img.shields.io/clojars/v/polyglot-spa.svg?colorB=blue)](https://clojars.org/polyglot-spa)

Pages are defined in a `<div class="page">`. It should contain an `id` and a `menuentry`.

`<script src="polyglot-spa/js/compiled/app.js">` will create a menu containing a a link to each page. It will be mounted at `<div id="menu">`.

For Routing a [Fragment router](https://metosin.github.io/reitit/frontend/browser.html) is used.

Examples:
* [Minimal](https://johannesloetzsch.github.io/polyglot-spa)
* [Realworld](https://github.com/multimodalrouting/multimodalrouting.github.io)

## Usage

1. Add the gh-pages branch (containing the compiled output) as submodule to your repository.

 > git submodule add --branch gh-pages https://github.com/johannesloetzsch/polyglot-spa.git polyglot-spa

2. Define the content of your SinglePageApplication within your own `index.html`. You can use this template:

```html
<!doctype html>
<html lang="en">
  <head>
    <meta charset='utf-8'>
    <!-- dependencies for re-com (bootstrap 3.3.5 and material-design 2.1.0) -->
    <link rel="stylesheet" href="polyglot-spa/vendor/css/bootstrap.min.css">
    <link rel="stylesheet" href="polyglot-spa/vendor/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="polyglot-spa/vendor/css/re-com.css">
  </head>
  <body>
    <div id="menu"></div> <!-- the menu will be mounted here -->


    <!-- Here we define our pages -->
    <div class="page" id="/home" menuentry="Home">Hello World</div>
    <div class="page" id="/page2" menuentry="Second Page">This is the second page of this tiny example</div>


    <script src="polyglot-spa/js/compiled/app.js"></script> <!-- after the last page -->
  </body>
</html>
```

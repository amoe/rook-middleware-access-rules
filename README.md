# rook-middleware-access-rules

[![Build Status](https://travis-ci.org/amoe/rook-middleware-access-rules.svg?branch=master)](https://travis-ci.org/amoe/rook-middleware-access-rules)

Implements a Rook middleware that you can use to apply authorization handlers to
your endpoints.

This is a library for Rook 1.x series, *not* the newer Rook 2.x that is a plugin
for the Pedestal framework.

## Installation

![](https://clojars.org/compojure/latest-version.svg)

## Usage

One function is exposed, `make-access-rules-middleware`.  It accepts one argument,
which is an error handler for buddy-auth authorization failures.  The signature
of this function is as such:

     (defn my-handler [request rejected-val]
       ;; Do something appropriate
       (-> "I'm sorry Dave" r/response (r/status 401)))

Access rules can choose to reject with a value, `(accessrules/error 42)`.  This
value becomes available inside the error handler as `rejected-val`.

Add it to your Rook namespace handler configuration thusly:

    (ns something
      (:require [solasistim.rook-middleware-access-rules
                   :refer [make-access-rule-middleware]]))

    (rook/namespace-handler
     {:default-middleware (make-access-rule-middleware error-handler)}
     ['solasistim.rook-middleware-access-rules.target-test-ns]))

Now set up your endpoint handlers as usual, but provide `:access-rule` key in
their metadata, which should be either a plain function or a map.

## License

Copyright © 2017 David Banks, LGPLv3

airbreathercore
===============

Contains dependencies that all of my mods rely on heavily.

In particular, it's where I dump reusable, modular abstractions (and,
occasionally, implementations) of the following, limiting consumers' exposure
to APIs that may be unstable and violate several principles of OOP that I care
about:

1. Event subscription
1. Item registration and retrieval
1. Recipe registration
1. Configuration of the above items
1. Mod lifecycle management
  1. Concrete implementation takes a modular composition of the above pieces.
  1. Uses those pieces together to run a standard sequence of actions during
     the well-defined "pre-init", "init", and "post-init" phases.
  1. Consumers now only need to provide their own implementations of each
     abstraction that encapsulates their needs, and provide a skeleton @Mod
     class that consumes this concrete implementation.

That's not to say that I think that these abstractions and/or implementations
are the best way to do OOP, or that I think my software is entirely better than
the software produced by Mojang, the FML team, the Forge team, or any other
group/individual who creates the software used by mods.  I simply prefer
working with loosely-coupled code where each necessary service is provided by a
well-defined abstraction.

Things I'm not particularly proud of that are my fault:

1. Handlers for new event types will require changes here.
1. Registration for new kinds of recipes will require changes here.

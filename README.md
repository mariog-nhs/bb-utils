# bb-utils

Where bb stands for Babashka (therefore, you need to install Clojure and Babashka to run the utilities stored in this repo).

## Clojure? Babashka? What?

OK, let me explain the buzzwords; else, you can jump to the [tasks section](#tasks).

### Clojure

A dialect of Lisp originally designed to target the JVM, there are also other versions targeting other runtimes...

### Babashka

... such as Babashka, which targets the GraalVM and is meant to be used for scripting, mainly as alternative to bash.

### OK, better now. So, what about the utils of this repo?

They are tasks, defined in the file `bb.edn`. Think of running tasks with npm or make, so, where you would have `npm run helloworld` or `make helloworld`, here you'd have `bb helloworld`.

## Tasks

The tasks/utils stored here are...

### Pull all (still uncompleted/WIP)

To pull all the repositories, in this case the ones used by the PRM team.

### Speedback

To generate the rounds for speedback sessions. Just pass the names of the people available to the relevant task, for example

`bb speedback name1 name2 name3`

If interested in the internal details and the logic to generate the cobinations, please refer to:

- [this](https://stackoverflow.com/questions/41896889/algorithm-to-schedule-people-to-an-activity-that-should-be-done-in-pairs#41897430) Stackoverflow conversration;
- [this](https://en.wikipedia.org/wiki/Round-robin_tournament#Scheduling_algorithm) Wikipedia page.


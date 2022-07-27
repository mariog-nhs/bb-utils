#!/usr/bin/env bb

(require '[clojure.java.shell :refer [sh]])

(def nhs-projects-dir "~/a-test-directory")

(def projects ["prm-deductions-base-infra"
               "prm-deductions-docker-openjdk-dojo"
               "prm-docker-node-dojo"
               "prm-deductions-ehr-repository"
               "prm-deductions-gp-to-repo"
               "prm-deductions-infra"
               "prm-deductions-repo-to-gp"
               "prm-deductions-system-e2e"
               "prm-docker-gocd-agent"
               "prm-gocd-infra"
               "prm-mesh-aws-forwarder"
               "prm-mhs-infra"
               "prm-practice-migration-dashboard"
               "prm-repo-continuity-service-e2e-tests"
               "prm-repo-ehr-transfer-service"
               "prm-repo-gp-registrations-mi-forwarder"
               "prm-repo-gp2gp-messenger"
               "prm-repo-mhs-ci"
               "prm-repo-nems-event-processor"
               "prm-repo-pds-adaptor"
               "prm-repo-pds-fhir-stub"
               "prm-repo-re-registration-service"
               "prm-repo-suspension-service"])

(defn to-ssh-url [reponame]
  (str "git@github.com:nhsconnect" reponame ".git"))

(defn to-project-map [reponame]
  {:name reponame :url (to-ssh-url reponame)})

(defn pull-all []
  (->> projects
       (map #(to-project-map (name %)))
       (take 1) ;; TODO: this will go :)
       ;; (sh #(str "git pull " nhs-projects-dir "/" %))
       ))

;; TODO:
;; handle logic to clone first time, or pull latest
;; set dynamically home path for repos

(comment
  (pull-all)

  )

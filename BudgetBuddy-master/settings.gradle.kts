pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
<<<<<<< HEAD
=======
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
>>>>>>> c80a1a945eaf2c32530012ce19303a1b7f15b930
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

<<<<<<< HEAD
rootProject.name = "BudgetTracker"
include(":app")
 
=======
rootProject.name = "BudgetBuddy"
include(":app")
>>>>>>> c80a1a945eaf2c32530012ce19303a1b7f15b930

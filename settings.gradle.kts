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
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Flight Search"
include(":app")
include(":core:common")
include(":core:database")
include(":core:network")
include(":feature:mainscreen")
include(":feature:flightsearch")
include(":feature:flightdetails")
include(":feature:hotels")
include(":feature:maps")
include(":feature:subscriptions")
include(":feature:profile")
include(":core:domain")
include(":core:data")

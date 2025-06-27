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

rootProject.name = "SHIFT_Android_TestTask"
include(":app")
include(":core")
include(":feature")
include(":core:common")
include(":core:domain")
include(":core:data")
include(":core:database")
include(":core:designsystem")
include(":core:network")
include(":feature:users")

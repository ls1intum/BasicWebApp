# Extreme Startup

For this exercise we will use an automated build pipeline to deploy a simple web application. We will use GitHub Actions and Heroku, which should be easy to set up.

### Set Up A Build Pipeline
#### Fork our web app on GitHub, clone it and get it running locally
Fork this repo into your own GitHub account.
Clone your fork locally and import the code into an IDE.
It’s a Java / Gradle project.

Run the main() method in ServerApplication. You should see the app running at http://localhost:8080.

#### Push a change to trigger GitHub Actions
The repository contains a .github directory that configures a GitHub Actions build pipeline.
The file .github/workflows/build.yml configures the build and deploy pipeline.

If you push a change to the Java code you should see the build pass, but the deploy stage will probably fail, as we need to set up a few more things.

If you aren’t familiar with build pipelines or GitHub Actions you can check the documentation online here: https://docs.github.com/en/actions / https://docs.github.com/en/actions/quickstart

#### Setting up deployment to the cloud
Create an account on Heroku at heroku.com (you’ll get a confirmation email etc).
Create an app on Heroku (either through the web UI or by installing the command line client).
Choose a unique name (e.g. we chose nameless-forest-60668 )

#### Setting up automatic deployment to Heroku with GitHub Actions
Get your Heroku API key and add it to GitHub as a secret variable for your build pipeline.
You can view your Heroku API key by going to Account settings > API Key > Reveal.
Add it by navigating to Settings > Secrets > Actions > New secret on your GitHub fork.
Also add your App name and your e-mail address there.

Docs on GitHub secrets here: https://docs.github.com/en/actions/security-guides/encrypted-secrets


Make a change to your application (e.g. change some HTML in IndexPage). Commit, push and check it is deployed (e.g. at https://nameless-forest-60668.herokuapp.com/).

#### Pushing changes through the pipeline
Now make a change to QueryProcessor (and its corresponding unit test) to make the app respond to a new query.
When the tests pass, commit, push, and deploy again.
Try intentionally breaking the build to make sure that only successful builds are deployed.

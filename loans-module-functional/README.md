# Loans Module.

## Getting started

This README.md file provides instructions for setting up and running the Java project using Maven. Follow the steps below to get started.

## Prerequisites

Before you begin, ensure you have the following software installed on your system:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)

## Installation Steps

### 1. Java Installation

If you don't have Java installed, follow these steps to install it:

1. Visit the [Oracle JDK Download Page](https://www.oracle.com/java/technologies/javase-downloads.html)..

2. Download the appropriate version of the JDK for your operating system.

3. Follow the installation instructions provided for your platform.

4. Verify your installation by running the following command in your terminal or command prompt:

   ```bash
   java -version
   ```

### 2. Maven Installation

If you don't have Maven installed, follow these steps to install it:

1. Visit the Maven Download Page.

2. Download the latest version of Maven.

3. Follow the installation instructions provided for your platform.

4. Verify your installation by running the following command in your terminal or command prompt:

```bash
mvn -version
```
You should see the installed Maven version.

## Step 3: Clone the Project Repository

To get a copy of the project on your local machine, follow these steps:

1. Open your terminal or command prompt.

2. Navigate to the directory where you want to clone the project repository. You can use the `cd` command to change directories.

   ```bash
   cd /path/to/your/desired/directory
   ```
3. Clone the project repository using Git by running the following command:

   ```bash
   git clone https://gitlab.com/jala-university1/cohort-1/software-development-2-es/secci-n-e/capstone/loan-module.git
   ```
    
   Replace your username with your GitHub username and your-java-project with the name of the Java project repository you want to clone.

4. Git will download the project files to your local directory. Once the cloning process is complete, you will have a local copy of the project on your machine.

Now you have successfully cloned the project repository to your local environment and can proceed with setting up and running the Java project.

### Step 4. Build and Run the Project

1. After cloning the repository, navigate to the project directory:

    ```bash
    cd loan-module
   ```

#### Maven Goals

The project may have various Maven goals defined in its pom.xml file. Here are some common goals you can use:

**Clean and Build:** This goal cleans the project and then builds it, compiling the source code and creating the output artifact.

```bash
mvn clean install
```
**Run the Application:** If the project is an application with a main method, you can use the following command to run it:

```bash
mvn exec:java
```
**Run Tests:** To execute the project's unit tests, use the following command:

```bash
mvn test
```

Refer to the project's documentation or pom.xml file for additional Maven goals and configuration options specific to the project.


## Project Structure

The project follows a standard Maven directory structure:

```
loan-module/
│
├── src/
│ ├── main/
│ │ ├── java/ # Java source code files
│ │ │ └── org.jala.university
│ │ │  ├── dao/ # Package to add custom Dao for the module
│ │ │  ├── domain/ # Package to add all the code with business logic for the module
│ │ │  └── presentation # Package to include all the UI code
│ │ └── resources/ # Resources (e.g., configuration files)
│ │
│ └── test/
│  ├── java/ # Test source code files
│  └── resources/ # Test resources
│
├── target/ # Compiled bytecode and packaged JARs
│
├── pom.xml # Project Object Model (POM) configuration
│
└── README.md # Project documentation (this file)
```
- **src/main/java**: This directory contains your main Java source code files. This is where you write the application code.

- **src/main/resources**: Resources necessary for the application, such as configuration files, properties, and templates, are placed here.

- **src/test/java**: Test source code files using JUnit or other testing frameworks reside here.

- **src/test/resources**: Test-specific resources, such as test configuration files or sample input data, are located in this directory.

- **target**: This directory is automatically generated by Maven. It contains compiled bytecode, JAR files, and other build artifacts.

- **pom.xml**: The Project Object Model (POM) file is used for configuring the project's dependencies, plugins, and other settings. It is the heart of the Maven project.


- **src/main/java/org/jala/university/domain/** All the functionality should be implemented on this module

- **src/main/java/org/jala/university/presentation/** Use this section to include all the UI functionality (the main view is *LoanView*)
- For database connection to tables please use the generic *AccountDAO* or *TransactionDAO*, or provide your own Dao that extend *AbstractDAO*


# GITLAB
To make it easy for you to get started with GitLab, here's a list of recommended next steps.

Already a pro? Just edit this README.md and make it your own. Want to make it easy? [Use the template at the bottom](#editing-this-readme)!

## Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/ee/gitlab-basics/add-file.html#add-a-file-using-the-command-line) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://gitlab.com/jala-university1/cohort-1/software-development-2-es/secci-n-e/capstone/loan-module.git
git branch -M main
git push -uf origin main
```

## Integrate with your tools

- [ ] [Set up project integrations](https://gitlab.com/jala-university1/cohort-1/software-development-2-es/secci-n-e/capstone/loan-module/-/settings/integrations)

## Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Set auto-merge](https://docs.gitlab.com/ee/user/project/merge_requests/merge_when_pipeline_succeeds.html)

## Test and Deploy

Use the built-in continuous integration in GitLab.

- [ ] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/index.html)
- [ ] [Analyze your code for known vulnerabilities with Static Application Security Testing(SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

***

# Editing this README

When you're ready to make this README your own, just edit this file and use the handy template below (or feel free to structure it however you want - this is just a starting point!). Thank you to [makeareadme.com](https://www.makeareadme.com/) for this template.

## Suggestions for a good README
Every project is different, so consider which of these sections apply to yours. The sections used in the template are suggestions for most open source projects. Also keep in mind that while a README can be too long and detailed, too long is better than too short. If you think your README is too long, consider utilizing another form of documentation rather than cutting out information.

## Name
Choose a self-explaining name for your project.

## Description
Let people know what your project can do specifically. Provide context and add a link to any reference visitors might be unfamiliar with. A list of Features or a Background subsection can also be added here. If there are alternatives to your project, this is a good place to list differentiating factors.

## Badges
On some READMEs, you may see small images that convey metadata, such as whether or not all the tests are passing for the project. You can use Shields to add some to your README. Many services also have instructions for adding a badge.

## Visuals
Depending on what you are making, it can be a good idea to include screenshots or even a video (you'll frequently see GIFs rather than actual videos). Tools like ttygif can help, but check out Asciinema for a more sophisticated method.

## Installation
Within a particular ecosystem, there may be a common way of installing things, such as using Yarn, NuGet, or Homebrew. However, consider the possibility that whoever is reading your README is a novice and would like more guidance. Listing specific steps helps remove ambiguity and gets people to using your project as quickly as possible. If it only runs in a specific context like a particular programming language version or operating system or has dependencies that have to be installed manually, also add a Requirements subsection.

## Usage
Use examples liberally, and show the expected output if you can. It's helpful to have inline the smallest example of usage that you can demonstrate, while providing links to more sophisticated examples if they are too long to reasonably include in the README.

## Support
Tell people where they can go to for help. It can be any combination of an issue tracker, a chat room, an email address, etc.

## Roadmap
If you have ideas for releases in the future, it is a good idea to list them in the README.

## Contributing
State if you are open to contributions and what your requirements are for accepting them.

For people who want to make changes to your project, it's helpful to have some documentation on how to get started. Perhaps there is a script that they should run or some environment variables that they need to set. Make these steps explicit. These instructions could also be useful to your future self.

You can also document commands to lint the code or run tests. These steps help to ensure high code quality and reduce the likelihood that the changes inadvertently break something. Having instructions for running tests is especially helpful if it requires external setup, such as starting a Selenium server for testing in a browser.

## Authors and acknowledgment
Show your appreciation to those who have contributed to the project.

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.
scout
=====

It's like this. You're building against some sort of service and your tests are breaking and you have no idea if it's your fault or theirs. And you're looking for someone to blame. Might be you, might be them, you don't even care. You just don't want to step through your code and add Yet More Logging, and the idea of you adding unit tests to *your* code to verify *someone else's* service inspires levels of anger previously only achieved that time that guy borrowed your car and returned it full of cigarette smoke and an empty tank just in time for you to be late to your job interview. 

Enter Scout.

Scout is a lightweight DropWizard service that will display the status of any services you choose. Run it from whatever machine you want and hit the built-in /ui/index.html or build your own UI on the /services REST resource. Your services are either Green or Not Green. There's no logging. No other information. Just enough for you to drag your boss over, say "See? Not my fault", and spend the rest of the day somewhere other than the office.

To use:
-------

Add our repository to your pom:

    <repository>
        <id>chiralbehaviors-snapshots</id>
        <url>http://repository-chiralbehaviors.forge.cloudbees.com/snapshot/</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>

Add your dependency:

    <dependency>
        <groupId>com.chiralbehaviors</groupId>
        <artifactId>scout</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>

Create your services. Implement the com.chiralbehaviors.scout.rest.Service interface. updateStatus() is where you put your service testing. 

Create a ScoutApplication. Extend the existing one. The only thing you need to do is return a list of your Service instances.

Create a yaml file for your server config. 

Start 'er up.

Check out the /src/test/ directory for an example app, example service, and example config file.

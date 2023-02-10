

def call() {
---
  name: Install Jenkins full package and installation as well
- hosts: ansible
  become: yes
  tasks:
   - name: download jenkins repo
     apt_key:
       url: https://pkg.jenkins.io/debian-stable/jenkins.io.key
       state: present
   - name: repository is configured
     apt_repository:
       repo: deb https://pkg.jenkins.io/debian-stable binary/
       state: present
   - name: apt update cache
     apt:
       update_cache: yes
       state: latest
   - name: Install Java
     apt:
       name: openjdk-11-jdk
       state: present
   - name: jenkins
     apt:
       name: jenkins
       state: latest
   - name: start jenkins
     service:
       name: jenkins
       enabled: true
       state: started
...
	}

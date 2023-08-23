# Jenkins + Github Webhook 연동 테스트 레포지토리 
## Jenkins
### plugins 
1. HTML Publisher
2. Generic Webhook Trigger
3. Discord Notifier
4. NodeJS

## Github
1. Personal Access Token 발급

## 주의사항
1. NodeJS 플러그인 인스톨 후 Pipeline Script에서 상단에 tools {nodejs : 'nodejs-$version'} 등으로 표기를 하는데,  
Jenkins System 설정에서 해당 이름의 NodeJS 가 지정되어있지 않으면 에러가 발생한다.

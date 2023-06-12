# 프로젝트(게임) 제목
팔라독
# 게임 컨셉
2D 횡스크롤 게임으로, '팔라독' 게임을 모작으로 만들었습니다. 웨이브마다 나오는 적을 물리치고 나아가 상대의 진영까지 돌격하여 승리하는 게임입니다. 플레이어에게는 마나와 식량 스탯이 있고 마나를 사용해서 직접 공격하거나, 식량을 소모하여 전투를 돕는 유닛을 뽑을 수 있습니다. 플레이어의 체력이 소진된 경우 게임이 종료됩니다.
![CameraMove](https://github.com/grjsm99/spgp_2023_2018182034/assets/44054161/dd7bece9-911b-40d6-a637-d7effa040471)
-> 실제 '팔라독' 게임 화면


# 개발 범위
게임 내 전투에 필요한 유닛 3종, 적 유닛 3종 공격, 이동 애니메이션 및 공격 구현, 플레이어의 이동, 스테이지 2개 구현 -> 스테이지 3개 구현

# 개발 진행도
![image](https://github.com/grjsm99/spgp_2023_2018182034/assets/44054161/c5ecba33-1268-49c7-8c04-b7ca107fad9c)

# 커밋 기록
![image](https://github.com/grjsm99/spgp_2023_2018182034/assets/44054161/b37247f3-d2f9-4e5d-9267-733a64c9d1c6)


저는 원작게임과 최대한 동일하게 자연스럽게 게임을 만드는것을 목표로 하였습니다.
기본적인 스프라이트 애니메이션이나 사운드 등은 수업시간에 배운것을 차용하였고,
그외로는 공격 및 유닛 클래스, 여러 UI클래스 등을 구현했습니다.
버튼 클래스 같은 경우 인터페이스를 사용하여 눌렀을때 호출될 함수를 정의하는 방식으로 하였고,
스프라이트를 상속받는 UI인 게이지, 숫자 등을 구현하였습니다.
아군, 적 미니언들은 이동,공격,죽음 등의 상태를 가지고 각자의 조건에 맞는 스프라이트와 행동을 하도록 하였습니다.

더 많은 종류의 아군 및 적 종류를 넣어보고 싶었지만, 프로젝트를 하면서 리소스를 구하는 어려움이 있어 한 종류의 미니언을
위해 일일히 한프레임씩 따 이미지를 만드는 과정이 너무 번거로워 계획 이상으로 더 하지 못한것이 아쉽습니다.
스마트폰 프로그래밍 수업을 들으면서 안드로이드 어플 개발에 대한 이해와 더불어 Java에 대한 이해도도 올라갔고, 
교수님의 코드를 보며 어떻게 하면 더 효율적이고 좋은 코드를 짤 수 있는지에 대해서도 더 생각해볼 수 있는 기회가 되었던 것 같습니다.

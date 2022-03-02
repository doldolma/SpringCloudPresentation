const { Grew } = require("../models");

data = [
    {
      id: 1,
      name: '이일봉',
      slogan: '처음처럼',
      nickname: '베네',
      belongsTo: '연구소장',
      image: 'https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_12.jpg',
      nicknameEng: 'bene',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 2,
      name: '김재식',
      slogan: 'if else',
      nickname: '카제',
      belongsTo: '개발 1팀',
      image: 'https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_15.jpg',
      nicknameEng: 'kaze',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 3,
      name: '권도훈',
      slogan: 'Never Give up!!',
      nickname: '엘로이',
      belongsTo: '개발 1팀',
      image: 'https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_74.jpg',
      nicknameEng: 'elory',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 4,
      name: '조아라',
      slogan: 'Rule your mind',
      nickname: '아리엘',
      belongsTo: '개발 1팀',
      image: 'https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_94.jpg',
      nicknameEng: 'arielle',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 5,
      name: '송민우',
      slogan: 'No pain No gain',
      nickname: '다니엘',
      belongsTo: '개발 1팀',
      image: 'https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_83.jpg',
      nicknameEng: 'daniel',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 6,
      name: '박은서',
      slogan: '바쁘게 살자! 봄찬 아빠!',
      nickname: '레이',
      belongsTo: '개발 2팀',
      image: 'https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_42.jpg',
      nicknameEng: 'ray',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 7,
      name: '김다라',
      slogan: '범사에 감사하라',
      nickname: '로야',
      belongsTo: '개발 2팀',
      image: 'https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_91.jpg',
      nicknameEng: 'roya',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 8,
      name: '권오인',
      slogan: '소중한 순간이 오면 따지지 말고 누릴 것!',
      nickname: '이썬',
      belongsTo: '개발 2팀',
      image: 'https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_2007_04.jpg',
      nicknameEng: 'ethan',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 9,
      name: '박종아',
      slogan: '모든 과정이 의미있게',
      nickname: '조아',
      belongsTo: '개발 2팀',
      image: 'https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_2111_03.jpg',
      nicknameEng: 'joah',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 10,
      name: '박예찬',
      slogan: '사모하는 일에 끝이 있나요',
      nickname: '리베',
      belongsTo: '개발 2팀',
      image: 'https://user-images.githubusercontent.com/81739782/154037302-6b7ee80e-06b7-4a7f-8bd7-8a2fdbb8d8f2.jpg',
      nicknameEng: 'liebe',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 11,
      name: '허도영',
      slogan: 'Why not',
      nickname: '돌마',
      belongsTo: '개발 2팀',
      image: 'https://user-images.githubusercontent.com/81739782/154037319-47a651ed-6f4c-4d19-96b0-69fcb1588d47.jpg',
      nicknameEng: 'dolma',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 12,
      name: '송은우',
      slogan: '오늘도 열심히 살자',
      nickname: '숀',
      belongsTo: '개발 3팀',
      image: 'https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_62.jpg',
      nicknameEng: 'sean',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 13,
      name: '김승혁',
      slogan: 'Stay Hungry, Stay foolish',
      nickname: '릭',
      belongsTo: '개발 3팀',
      image: 'https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_82.jpg',
      nicknameEng: 'rick',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 14,
      name: '조현진',
      slogan: 'Grow in green',
      nickname: '헤이즐',
      belongsTo: '개발 3팀',
      image: 'https://user-images.githubusercontent.com/81739782/154036600-7bc7a12f-b669-4c32-b5fe-28d22a3031dd.jpeg',
      nicknameEng: 'hazel',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 15,
      name: '김상호',
      slogan: '知之者不如好之者',
      nickname: '조엘',
      belongsTo: '개발 4팀',
      image: 'https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_24.jpg',
      nicknameEng: 'joel',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 16,
      name: '최한규',
      slogan: 'Break the mold!',
      nickname: '리암',
      belongsTo: '개발 4팀',
      image: 'https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_43.jpg',
      nicknameEng: 'liam',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 17,
      name: '정승환',
      slogan: "Let's go out!",
      nickname: '트레버',
      belongsTo: '개발 4팀',
      image: 'https://www.gridwiz.com/assets/images/culture/team-gridwiz/GW_Web_Profile_18.jpg',
      nicknameEng: 'trevor',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    },
    {
      id: 18,
      name: '김설아',
      slogan: 'Dream but Stay Awake! ',
      nickname: '사라',
      belongsTo: '개발 4팀',
      image: 'https://user-images.githubusercontent.com/81739782/154036612-bc35c495-9108-4426-9db9-afbe429e9499.jpg',
      nicknameEng: 'sarah',
      createdAt: '2022-02-15T12:36:04.000Z',
      updatedAt: '2022-02-15T12:36:04.000Z',
      lettersCount: 0
    }
  ];

  module.exports = async () => {
    const count = await Grew.count();
    if(count > 0) return false;

    await Grew.bulkCreate(data);
  };
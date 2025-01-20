const base = {
   get() {
      return {
         url: "http://localhost:8080/travel/",
         name: "travel",
         // 退出到首页链接
         indexUrl: "http://localhost:8080/travel/front/index.html",
      };
   },
   getProjectName() {
      return {
         projectName: "奇妙旅程-后台管理",
      };
   },
};
export default base;

-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 16, 2015 at 02:18 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `resumebot`
--

-- --------------------------------------------------------

--
-- Table structure for table `applicants`
--

CREATE TABLE IF NOT EXISTS `applicants` (
  `lname` varchar(30) NOT NULL,
  `fname` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `linkedin` varchar(100) NOT NULL,
  `linkedindata` text NOT NULL,
  `resume` varchar(100) NOT NULL,
  `resumedata` text NOT NULL,
  `tenth` int(5) NOT NULL,
  `twelfth` int(5) NOT NULL,
  `ug` int(5) NOT NULL,
  `ugcollege` varchar(100) NOT NULL,
  `pg` int(5) NOT NULL,
  `pgcollege` varchar(100) NOT NULL,
  `experience` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `applicants`
--

INSERT INTO `applicants` (`lname`, `fname`, `email`, `mobile`, `linkedin`, `linkedindata`, `resume`, `resumedata`, `tenth`, `twelfth`, `ug`, `ugcollege`, `pg`, `pgcollege`, `experience`) VALUES
('A', 'Prabakaran', 'prabakaran@gmail.com', '8807574260', 'https://in.linkedin.com/in/prabaprakash', 'fs.config({"failureRedirect":"https://www.linkedin.com/public-profile/internal-server-error","uniEscape":true,"xhrHeaders":{"X-FS-Origin-Request":"/in/prabaprakash","X-FS-Page-Id":"nprofile-public-vanity"}});fs._server.fire("public_profile",{event:"before",type:"html"});\n\n\n\n\n\n  \n\n\nPraba Prakash | LinkedIn\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nLinkedIn Home\n\n\n\n\n\n\nWhat is LinkedIn?\n\n\n\n\nJoin Today\n\n\n\n\nSign In\n\n\n\n\n\n\n\nMain content starts below.\n\n\n(function(n,r,a){r=window[n]=window[n]||{};r[''jsecure_injectAlert'']=''control'';r[''jsecure_Dialog'']=''control'';}(''__li__lix_registry__''));\n\n\nif(dust){dust.debugLevel="NONE";}Praba PrakashMicrosoft Student Partner at MicrosoftLocationChennai Area, IndiaIndustryComputer SoftwareCurrentMicrosoftEducationVellore Institute of Technology500+ connectionsJoin LinkedIn and access Prabaâ€™s full profile. Itâ€™s free!As a LinkedIn member, youâ€™ll join 300 million other professionals who are sharing connections, ideas, and opportunities.See who you know in commonGet introducedContact Praba directlyView Praba''s Full ProfileSummaryI am Prabakaran.Ahttps://github.com/prabaprakashIndependent Windows 8 Metro/WinRt/Phone App Developer & Enthusiastic in Big Data Analytic, DOT NET, J2EE, PHP & Open Source Tools( Oct 2012 - Present).My Application With All-Metro StandardsExpert Tamil Dictionary (Windows 8 Metro / Mobile)Windows 8 Metro/WinRThttp://apps.microsoft.com/windows/en-in/app/expert-tamil-dictionary/bb1706f6-8b4a-458d-a825-470d344f6309Windows Phone 8http://www.windowsphone.com/en-in/store/app/expert-tamil-dictionary/abc9c376-c035-4ac9-bcb9-18a0d37d3f24Articles By Me .:Apache Hadoop for Windows Platformhttp://www.codeproject.com/Articles/757934/Apache-Hadoop-for-Windows-PlatformWindows 8 Metro Sample Apps By Me .:http://code.msdn.microsoft.com/site/search?f[0].Type=User&f[0].Value=PrabaPrakashFrom Tiruvannamalai,TamilNadu,India.I Studied In Mount Saint Joseph Mat Hr Sec School-Tiruvannamalai(2010 - 2011 Batch)Now I am Studying Ms Software Engineering In VIT Chennai Campus(2011 - 2016 Batch)I am a Crazy Microsoft Fans, Never Lose Microsoft while debates with friends.Because Of Windows 8 OS, DOT Net Framework, C#, SilverLight, Linq, Visual Studio IDE, I Love This More.....More or Less Microsoft ProvidingDreamspark, MVA, WebisteSpark, YouthSpark, Code.MSDN.Com, Codeplex.com, Channel9.msdn.com,...ExperienceMicrosoft Student PartnerMicrosoftOctober 2014 â€“ Present (1 year 2 months)Chennai Area, IndiaRun workshops and hackathons Host tech events and give demos on campus Work alongside Microsoft professionals, assisting them during hackathons.CoursesVellore Institute of TechnologyBig Data Cloud Data Structures and Algorithms (IT203)Computer Architecture (SWE203)Database Management Systems (SWE303)Computer Networks (SWE308)Principles of Software Engineering (SWE307)Requirements Engineering (SWE310)Software Architecture Design (SWE401)Software Construction and Maintenance (SWE405)Software Project Management (SWE406)Software Testing (SWE411)Software Configuration Management (SWE512)Software Quality and Reliability (SWE504)Software Metrics (SWE505)Software Engineering Process Tools and methods (SWE503)Design Patterns (SWE501)Programming in C, C++, Java (SWE101,204)Operating System (SWE305)Code Y-Gen Club (EXC141)Artificial Intelligence and Intelligent Systems (SWE510)Advanced Java Programming (SWE517)Distributed Computing (SWE509)Biometric Systems (SWE415)Web Services and Service Oriented Architecture (SWE409)Data Warehousing and Data Mining (SWE413)Open Source Programming (SWE407)Volunteer Experience &amp; CausesTechnical SupportAndroid Amaze 24Hrs HackathonMarch 2015 â€“ April 2015 (2 months)It''s was awesome, I helped participants having issues in installing Android Studio & Android Programming. my best part is, "one team from Andhra Pradesh" having a problem in Dot Net Socket Programming, I found the issue by analyzing the source code more than 2 hours.Opportunities Praba is looking for:Skills-based volunteering (pro bono consulting)Causes Praba cares about:ChildrenEducationEnvironmentHealthScience and TechnologySocial ServicesLanguagesEnglishProfessional working proficiencyTamilNative or bilingual proficiencySkillsC++JavaCPHPMicrosoft OfficeMySQLHTMLVisual StudioJavaScriptC#WindowsASP.NETJSPServletsWeb ServicesSee 20+EclipseSQLResearchTeamworkSocial MediaTime ManagementGoogle App EnginecssjQueryAJAXIntelliJ IDEANet Beans IDEHadoopSQLiteMongoDBHiveapache hadoopHBaseApache PigUbuntuSee lessEducationVellore Institute of TechnologyMaster of Science (MS), Software Engineering, 8.252011 â€“ 2016It''s awesome Experience. Enjoyed High-Speed Internet Connectivity. Enjoyed learning Programming, Networking, Data Structures, App-fest, Hackathon.Activities and Societies: Won First Prize Rs.1500 for Windows Appathon Fest. It&#39;s Eight Hour Microsoft Windows App Fest, Conducted by Microsoft Innovation Center.Mount Saint Joseph Matriculation Higher Secondary School, Tiruvannamalai+2, Computer Science, 75.52010 â€“ 2011InterestsPlayingCodingCertificationsBig Data Training3x3conectNovember 2014 â€“ PresentASP.NETVellore Institute of Technology - Chennai, School of Computer Science and EngineeringApril 2014 â€“ PresentAzure Cloud Training3x3conectNovember 2014 â€“ PresentProgramming in C# Jump StartMicrosoft Virtual AcademyAugust 2014 â€“ PresentOrganizationsMicrosoftMicrosoft Student PartnerStarting September 2014PublicationsApache Hadoop for Windows PlatformCodeproject.comJuly 2014Article will be helpful for Beginners & Intermediary Programmers to Bootstrap Apache Hadoop (Big Data Analytics Framework ) in Windows Environment.Authors: Praba PrakashSqlite For Windows 8 Metro/Winrt Appscode.msdn.microsoft.comJuly 2013Authors: Praba PrakashProjectsBig Data Analytic in Web ServiceSeptember 2014 â€“ November 2014Running Data Analytic in Web-service by ASP.NET. Food Recipe Dataset - Unstructured Data -JSON Format - 1.5 Lakhs Food Recipes Big-Data-Analytics azure NoSql MongoDB ASPTeam members: Praba PrakashExpert Tamil DictionaryOctober 2012 â€“ December 2013It''s Windows App.No Internet Connection Is Required. Expert English To Tamil Dictionary with high powered search engine, Added Sixty thousand words and meanings for users.Sqlite JSON C#Team members: Praba PrakashInternet Based Garage Door Control SystemJanuary 2015 â€“ May 2015Using the classic Arduino Uno development board with an Internet connection to provide a means to open an electrically powered garage door using a web browser, smartphone, or tablet.C++ ArduinoTeam members: Praba Prakash2048 Game SolverJanuary 2015 â€“ May 2015Solving 2048 Tile Game using Artificial Intelligence. Algorithm used MinMax and Alpha Beta Pruning AlgorithmJava Artificial-Intelligence MINMAX ALPHA-BETA-PRUNINGTeam members: Praba PrakashMedia Player for Windows Metro/RTMarch 2013 â€“ September 2013Developed Windows Metro Application by following all UI Design Rules and Regulation. Learning Current Trends in UI Design Industries for ImplementingMicrosoft-Player-Framework C# JSON XAML UI/UXTeam members: Praba PrakashNetwork ScannerJuly 2013 â€“ November 2013Network Scanner is to find and analyze the IP address and port number of all computers which had configured and connected by WiFi.C++ C# NetworksTeam members: Praba PrakashExamination ManagementFebruary 2013 â€“ May 2013Developed Cloud Based Application, to Conduct Online Examination, to Maintain The Records Of Examiners in Cloud Database.Java JFrame SqlTeam members: Praba PrakashHonors &amp; AwardsEditor&#39;s Pick Award - Best Windows 8 Appsbestwindows8apps.netAugust 2014bestwindows8apps.net/app/expert_tamil_dictionary,I was award for Best Windows 8 EducationalAppsGroupsFuture of Energy by ShellView Prabaâ€™s full profile to...See who you know in commonGet introducedContact Praba directlyView Praba''s Full ProfileNot the Praba youâ€™re looking for? View moreFind a different Praba PrakashFirst NameLast NameExample:  Praba Prakashpraba prakashComputer Software ProfessionalIndiaMore professionals named Praba PrakashPeople Also ViewedShrihari NelloreStudent at Jawaharlal Nehru Tecnological University , Anantapur IndiaVandan Kumbhat (Jain)Student at Vellore Institute of TechnologyShweta SinghCreating Employment Exchange Portal for VIT AlumniJaisudha M D B--Balavishnu V JStudent at Vellore Institute of TechnologySailesh DevSoftware architectSubham AgarwalStudent at Vellore Institute of TechnologyGaurav ShalinStudent at Vellore Institute of TechnologySoumiya SrinivasanStudent at VIT UniversityKoneru NikhilTechnical lead at Google Student Clubwindow.addEventListener(''load'',function(){var iframes=document.getElementsByTagName("iframe");for(var i=0;i', 'prabakaran@gmail.com.docx', '\r\nPRABAKARAN A\r\nMaster of Science\r\n05/05/1993 | 8807574260 | prabakaran1993@hotmail.com 543/3, Deepam Nagar, Tiruvannamalai, Tamil Nadu - 606604\r\n\r\nEDUCATION\r\nSCHOLASTIC  ACHIEVEMENTS\r\n2011 - 2016\r\nSoftware Engineering (CGPA: 8.25 ) Master  of Science\r\nVellore Institute of Technology, Chennai\r\n2010 - 2011\r\nComputer Science (CGPA: 75.5 ) 12th Class\r\nMount Saint Joseph Matric Hr Sec School\r\n2008 - 2009\r\n(CGPA: 78.8 )10th Class\r\nMount Saint Joseph Matric Hr Sec School\r\nEXPERIENCE\r\n\r\nSep 2014 - Currently Working\r\nMicrosoft Student Partner, Microsoft (Social Work)\r\nRun workshops and hackathons Host tech events and give demos on campus Work alongside Microsoft professionals, assisting them during hackathonsNov 2014\r\nBig Data Analytic, 3X3 ConectMicrosoft Innovation Center, Vellore Institute of Technology, Chennai Campus had conducted Training and Certification program for Big Data Analytic\r\nNov 2014\r\nAzure Cloud, 3x3conect\r\nMicrosoft Innovation Center, Vellore Institute of Technology, Chennai Campus had conducted Training and Certification program for Microsoft Azure\r\nMay 2014\r\nASP.NET, Vellore Institute of Technology - Chennai\r\nACTIVITIES\r\nSchool of Computer Science and Engineering, VIT Chennai had conducted an ASP.NET Training and Certification Program by Microsoft  Innovation Center.\r\nC#\r\n ASP\r\n Networks\r\n Java\r\n\r\nPROJECTS\r\n\r\nBig Data Analytic in Web-Service (Sep 2014 - Currently Working)\r\nDeveloper\r\nSite: praba.azurewebsites.net/Home.aspx, running Data Analytic in Web-service by ASP.NET. Food Recipe Dataset - Unstructured Data - JSON Format - 1.5 Lakhs Food Recipes\r\nBig-Data-Analytics\r\n azure NoSql MongoDB ASP\r\n\r\nExpert Tamil Dictionary (Oct 2012 - Dec 2013)\r\nDeveloper\r\nIt''s Windows App.No Internet Connection Is Required. Expert English To Tamil Dictionary with high powered search engine, Added Sixty thousand words and meanings for users.\r\nSqlite JSON\r\n C#\r\n\r\nInternet Based Garage Door Control System (Jan 2015 - May 2015)\r\nDeveloper\r\nUsing the classic Arduino Uno development board with an Internet connection to provide a means to open an electrically powered garage door using a web browser, smartphone, or tablet.\r\nC++\r\n Arduino\r\n\r\n2048 Game Solver (Jan 2015 - May 2015)\r\nDeveloper\r\nJava\r\nArtificial-Intelligence\r\nMINMAX\r\nSolving 2048 Tile Game using Artificial Intelligence. Algorithm used MinMax and Alpha Beta Pruning Algorithm\r\nALPHA-BETA-PRUNING\r\nMedia Player for Windows Metro/RT (Mar 2013 - Sep 2013)\r\nDeveloper\r\nMicrosoft Windows App Fest (Apr 2013 - Apr 2013)\r\n1st Position, Vellore Institute of Technology,\r\nChennai\r\nIt''s Eight Hour Microsoft Windows App Fest, Conducted by Microsoft Innovation Center. I Won the first prize RS.1500 for Expert Tamil Dictionary - Windows 8 Phone App.\r\n24 Hour Big Data Appathon (Sep 2014 - Sep 2014)\r\nRunner, Vellore Institute of Technology,\r\nChennai\r\nRecipe Dataset - Unstructured Data - Json Format - 1.5 Lakhs Recipes, processed by Hadoop 2.5 using Java Map Reduce Program\r\n24 Hour Cloud Appathon (Oct 2014 - Oct 2014)\r\nRunner, Vellore Institute of Technology,\r\nChennai\r\n"Selfie App" - Windows Store App, Using Asp.NET Web Service and Azure Cloud.\r\nMicrosoft App Fest (Sep 2014 - Sep 2014) Runner, Vellore Institute of Technology, Chennai\r\nIt''s Eight Hour App fest, Conducted by Microsoft Innovation Center. I Developed Metro Player Using Microsoft Player Framework which Support Direct Media Playback.\r\nDeveloped Windows Metro Application by following all UI Design Rules and Regulation. Learning Current Trends in UI Design Industries for Implementing\r\nMicrosoft-Player-Framework\r\n C#\r\n JSON\r\n XAML\r\n UI/UX\r\n\r\nFacial Recognition (Feb 2014 - May 2014)\r\nDeveloper\r\nDeveloping Facial recognition software using OpenCV Library by four stages Process: Image acquisition, Image processing, Distinctive characteristic location, Template creation, Template matching.\r\nC#\r\n OpenCv\r\nNetwork Scanner (Jul 2013 - Nov 2013)\r\nDeveloper\r\nNetwork Scanner is to find and analyze the IP address and port number of all computers which had configured and connected by WiFi.\r\nMicrosoft Build The Shield (Feb 2015 - Feb 2015) Runner, Microsoft Student Partner''s Competition\r\nIt''s 24 Hour, Online Microsoft Security Hackathon.\r\nAWARDS AND HONOURS\r\n\r\nEditor''s Pick Award - Best Windows 8 Apps Aug 2014\r\nbestwindows8apps.net\r\nSKILLS\r\nbestwindows8apps.net/app/expert_tamil_dictio I was award for Best Windows 8 Educational Apps\r\nC++\r\n C#\r\n Networks\r\n\r\nC#JavaBig Data AnalyticsWindows\r\nApplication\r\nC++\r\nNetworks\r\nPHP\r\nDatabase management\r\nC\r\nProxy Server (Aug 2014 - Oct 2014)\r\nLANGUAGES SPOKEN\r\nDeveloper\r\nEnglish\r\nTamil\r\nA Proxy Server is software running on a computer located somewhere between a remote user and the Internet resources the user wishes to access.\r\nPHP\r\n Curl\r\n\r\nHOBBIES\r\nExamination Management (Feb 2013 - May 2013)\r\nCricket\r\nMusic\r\nHollywood\r\nDeveloper\r\nDeveloped Cloud Based Application, to Conduct Online Examination, to Maintain The Records Of Examiners in Cloud Database.\r\nJava\r\n JFrame Sql\r\nQuick XML Reader (Jan 2014 - May 2014)\r\nDeveloper\r\nIn Big Data Analytic, I will work with huge XML files and we want to be able to view the content of those files reasonably quickly, I decide to develop an INTERPRETER to open XML file quick.\r\nINTERPRETER\r\n XML\r\n XAML\r\n C#\r\n\r\n', 78, 76, 82, '', 82, '', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

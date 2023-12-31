USE [WEB_XEM_PHIM]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[category_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Comment]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comment](
	[id_comment] [int] IDENTITY(1,1) NOT NULL,
	[movie_id] [int] NULL,
	[user_id] [int] NULL,
	[comment] [ntext] NOT NULL,
	[value] [int] NOT NULL,
	[date] [datetime] NULL,
 CONSTRAINT [PK_Comment] PRIMARY KEY CLUSTERED 
(
	[id_comment] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Company]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Company](
	[company_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Company] PRIMARY KEY CLUSTERED 
(
	[company_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Country]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Country](
	[country_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Country] PRIMARY KEY CLUSTERED 
(
	[country_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Episode]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Episode](
	[episode_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[episode] [int] NOT NULL,
	[season] [nvarchar](50) NOT NULL,
	[source] [nvarchar](255) NOT NULL,
	[movie_id] [int] NOT NULL,
	[day_submit] [datetime] NULL,
 CONSTRAINT [PK_Episode] PRIMARY KEY CLUSTERED 
(
	[episode_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[History]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[History](
	[user_id] [int] NOT NULL,
	[episode_id] [int] NOT NULL,
	[time_stamp] [float] NULL,
 CONSTRAINT [PK_History] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC,
	[episode_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Language]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Language](
	[language_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Language] PRIMARY KEY CLUSTERED 
(
	[language_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie](
	[movie_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[movie_content] [ntext] NOT NULL,
	[episodes] [int] NULL,
	[movie_schedule] [int] NOT NULL,
	[image] [nvarchar](255) NOT NULL,
	[country_id] [int] NOT NULL,
	[views] [int] NULL,
 CONSTRAINT [PK_Movie] PRIMARY KEY CLUSTERED 
(
	[movie_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie_Category]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie_Category](
	[movie_id] [int] NOT NULL,
	[category_id] [int] NOT NULL,
 CONSTRAINT [PK_Movie_Category] PRIMARY KEY CLUSTERED 
(
	[movie_id] ASC,
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie_Collection]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie_Collection](
	[movie_id] [int] NOT NULL,
	[user_id] [int] NOT NULL,
	[time] [datetime] NOT NULL,
 CONSTRAINT [PK_Movie_Collection] PRIMARY KEY CLUSTERED 
(
	[movie_id] ASC,
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie_Company]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie_Company](
	[movie_id] [int] NOT NULL,
	[company_id] [int] NOT NULL,
 CONSTRAINT [PK_Movie_Company] PRIMARY KEY CLUSTERED 
(
	[movie_id] ASC,
	[company_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie_Language]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie_Language](
	[movie_id] [int] NOT NULL,
	[language_id] [int] NOT NULL,
	[type] [int] NULL,
 CONSTRAINT [PK_Move_Language] PRIMARY KEY CLUSTERED 
(
	[movie_id] ASC,
	[language_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie_Person]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie_Person](
	[movie_id] [int] NOT NULL,
	[person_id] [int] NOT NULL,
 CONSTRAINT [PK_Movie_Person] PRIMARY KEY CLUSTERED 
(
	[movie_id] ASC,
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie_User]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie_User](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[user_name] [varchar](50) NULL,
	[password] [varchar](255) NULL,
	[name] [nvarchar](20) NULL,
	[email] [varchar](100) NULL,
	[role_id] [int] NULL,
	[avatar] [varchar](255) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Person]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Person](
	[person_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[gender] [int] NULL,
	[day_of_birth] [datetime] NULL,
	[image] [varchar](100) NOT NULL,
	[describe] [ntext] NULL,
	[country_id] [int] NULL,
 CONSTRAINT [PK_Person] PRIMARY KEY CLUSTERED 
(
	[person_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[role_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Search_Input]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Search_Input](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[sentence] [nvarchar](500) NOT NULL,
 CONSTRAINT [PK_Search_Input] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([category_id], [name]) VALUES (1, N'Tình cảm')
INSERT [dbo].[Category] ([category_id], [name]) VALUES (2, N'Hành động')
INSERT [dbo].[Category] ([category_id], [name]) VALUES (3, N'Gia đình')
INSERT [dbo].[Category] ([category_id], [name]) VALUES (4, N'Cổ trang')
INSERT [dbo].[Category] ([category_id], [name]) VALUES (5, N'Khoa học viễn tưởng')
INSERT [dbo].[Category] ([category_id], [name]) VALUES (6, N'Kinh dị')
INSERT [dbo].[Category] ([category_id], [name]) VALUES (7, N'Hài')
INSERT [dbo].[Category] ([category_id], [name]) VALUES (8, N'Hoạt hình')
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[Comment] ON 

INSERT [dbo].[Comment] ([id_comment], [movie_id], [user_id], [comment], [value], [date]) VALUES (55, 9, 1, N'good movie', 3, CAST(N'2023-10-01T11:00:07.397' AS DateTime))
INSERT [dbo].[Comment] ([id_comment], [movie_id], [user_id], [comment], [value], [date]) VALUES (56, 7, 1, N'aaaaa', 1, CAST(N'2023-10-07T13:56:45.640' AS DateTime))
INSERT [dbo].[Comment] ([id_comment], [movie_id], [user_id], [comment], [value], [date]) VALUES (57, 7, 1, N'ssssss', 1, CAST(N'2023-10-07T14:00:38.143' AS DateTime))
INSERT [dbo].[Comment] ([id_comment], [movie_id], [user_id], [comment], [value], [date]) VALUES (58, 7, 1, N'sssssssss', 1, CAST(N'2023-10-07T14:06:05.147' AS DateTime))
INSERT [dbo].[Comment] ([id_comment], [movie_id], [user_id], [comment], [value], [date]) VALUES (59, 7, 1, N'bbbbbbb', 1, CAST(N'2023-10-07T14:06:32.230' AS DateTime))
INSERT [dbo].[Comment] ([id_comment], [movie_id], [user_id], [comment], [value], [date]) VALUES (60, 7, 1, N'thử nghiệm code binh luận', 1, CAST(N'2023-10-17T17:49:29.327' AS DateTime))
INSERT [dbo].[Comment] ([id_comment], [movie_id], [user_id], [comment], [value], [date]) VALUES (61, 7, 1, N'thử nghiệm code binh luận', 1, CAST(N'2023-10-17T17:49:45.300' AS DateTime))
SET IDENTITY_INSERT [dbo].[Comment] OFF
GO
SET IDENTITY_INSERT [dbo].[Company] ON 

INSERT [dbo].[Company] ([company_id], [name]) VALUES (1, N' Nippon Television Network')
INSERT [dbo].[Company] ([company_id], [name]) VALUES (2, N'Houbunsha')
INSERT [dbo].[Company] ([company_id], [name]) VALUES (3, N' ufotable')
SET IDENTITY_INSERT [dbo].[Company] OFF
GO
SET IDENTITY_INSERT [dbo].[Country] ON 

INSERT [dbo].[Country] ([country_id], [name]) VALUES (1, N'VN')
INSERT [dbo].[Country] ([country_id], [name]) VALUES (2, N'United States')
INSERT [dbo].[Country] ([country_id], [name]) VALUES (3, N'Janpan')
INSERT [dbo].[Country] ([country_id], [name]) VALUES (4, N'Vietnam')
SET IDENTITY_INSERT [dbo].[Country] OFF
GO
SET IDENTITY_INSERT [dbo].[Episode] ON 

INSERT [dbo].[Episode] ([episode_id], [name], [episode], [season], [source], [movie_id], [day_submit]) VALUES (9, N'Ep 1', 1, N'season 1', N'Ep 1_10h56m4s.mp4', 7, CAST(N'2023-10-01T10:56:04.953' AS DateTime))
INSERT [dbo].[Episode] ([episode_id], [name], [episode], [season], [source], [movie_id], [day_submit]) VALUES (11, N'Tập 1', 1, N'Mùa xuân', N'Tập1_7h44m16s.mp4', 8, CAST(N'2023-11-07T07:44:16.477' AS DateTime))
SET IDENTITY_INSERT [dbo].[Episode] OFF
GO
SET IDENTITY_INSERT [dbo].[Language] ON 

INSERT [dbo].[Language] ([language_id], [name]) VALUES (1, N'English')
INSERT [dbo].[Language] ([language_id], [name]) VALUES (2, N'Việt Nam')
SET IDENTITY_INSERT [dbo].[Language] OFF
GO
SET IDENTITY_INSERT [dbo].[Movie] ON 

INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (7, N'THE THREE MUSKETEERS', N' Leaving his country village, D''Artagnan (Douglas Fairbanks) heads to Paris in hopes of becoming a musketeer.', 1, 3, N'three.png', 2, 10)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (8, N'Kimi no Na wa.', N'Mitsuha Miyamizu, a high school girl, yearns to live the life of a boy in the bustling city of Tokyo—a dream that stands in stark contrast to her present life in the countryside. Meanwhile in the city, Taki Tachibana lives a busy life as a high school student while juggling his part-time job and hopes for a future in architecture.', 1, 4, N'yourname.png', 3, 100)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (9, N'Princess Mononoke', N'When an Emishi village is attacked by a fierce demon boar, the young prince Ashitaka puts his life at stake to defend his tribe. With its dying breath, the beast curses the prince''s arm, granting him demonic powers while gradually siphoning his life away. Instructed by the village elders to travel westward for a cure', 12, 3, N'PrincessMononoke_10h42m15s.png', 3, 0)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (10, N'Mahou Shoujo Madoka', N'The young girls of Mitakihara happily live their lives, occasionally fighting off evil, but otherwise going about their peaceful, everyday routines. However, Homura Akemi feels that something is wrong with this unusually pleasant atmosphere—though the others remain oblivious, she can''t help but suspect that there is more to what is going on than meets the eye: someone who should not exist is currently present to join in on their activities.', 1, 3, N'MahouShoujoMadoka_10h47m6s.png', 3, 0)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (13, N'Natsume Yujin-cho', N'Takashi Natsume and his spirit companion Madara, nicknamed "Nyanko," continue returning the names of spirits from the Book of Friends given by his late grandmother Reiko Natsume.', 13, 3, N'NatsumeYujin-cho_11h2m44s.png', 3, 0)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (14, N'Steins;Gate', N'ccentric scientist Rintarou Okabe has a never-ending thirst for scientific exploration. Together with his ditzy but well-meaning friend Mayuri Shiina and his roommate Itaru Hashida, Rintarou founds the Future Gadget Laboratory in the hopes of creating technological innovations that baffle the human psyche. ', 1, 4, N'SteinsGate_11h4m16s.png', 3, 0)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (15, N'Bocchi the Rock!', N'Yearning to make friends and perform live with a band, lonely and socially anxious Hitori "Bocchi" Gotou devotes her time to playing the guitar. On a fateful day, Bocchi meets the outgoing drummer Nijika Ijichi', 1, 4, N'BocchitheRock!_11h13m11s.png', 3, 0)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (17, N'Die Hard', N'Die Hard là phim điện ảnh hành động giật gân của Mỹ năm 1988 do John McTiernan đạo diễn cùng kịch bản do Jeb Stuart và Steven E. de Souza chấp bút, với sự tham gia diễn xuất của Bruce Willis và Alan Rickman.', 1, 2, N'DieHard.png', 2, 10)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (18, N'Mad Max: Fury Road', N'
Phim mới lấy bối cảnh thế giới ở thời kỳ văn minh nhân loại đã sụp đổ, con người trở nên mất nhân tính và cuồng điên trong những trận chiến để giành giật sự sống, các nhu yếu phẩm như nước và xăng. Thế giới giờ là sa mạc mênh mông, con người chia làm nhiều phe chuyên giết nhau để tồn tại. Đứng giữa cuộc chạy đua vũ trang và phản kháng khốc liệt. 
', 1, 2, N'Max_Mad_Fury_Road_Newest_Poster.png', 2, 10)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (20, N'John Wick', N'
Bộ phim tập trung vào John Wick (Reeves), một cựu sát thủ tìm cách trả thù những kẻ đột nhập vào nhà anh ta, lấy trộm chiếc xe cổ và giết chú chó con của Wick (Daisy), đó là món quà cuối cùng của anh từ người vợ vừa qua đời Helen (Moynahan).
', 1, 2, N'john.png', 2, 10)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (21, N'Gladiator', N'
Vào năm 180 sau Công nguyên, tướng Maximus Decimus Meridius chỉ huy quân đội La Mã đã có một chiến thắng quyết định, đánh bại bộ tộc man rợ người German ở Vindobona, kết thúc cuộc chiến lâu dài tại biên giới La Mã và được sự tín nhiệm của hoàng đế cao tuổi Marcus Aurelius. Mặc dù ông đã có một con trai nối dõi: Commodus, nhưng hoàng đế muốn giao Maximus quyền lãnh đạo tạm thời khi mình qua đời, mong muốn anh cuối cùng sẽ trả lại quyền lực cai trị đế quốc cho Viện nguyên lão. Khi Aurelius nói với Commodus về quyết định này, Commodus đã cay đắng vì cha không cho mình kế vị mà ủng hộ Maximus hơn, nên sau đó Commodus đã giết cha của mình trong sự giận dữ và tuyên bố lên ngôi.
', 1, 2, N'GladiatorDVD.png', 2, 10)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (22, N'Titanic', N'
n 1996, aboard the research vessel Akademik Mstislav Keldysh, Brock Lovett and his team search the wreck of RMS Titanic. They recover a safe they hope contains a necklace with a large diamond known as the Heart of the Ocean. Instead, they find only a drawing of a young nude woman wearing the necklace. The sketch is dated April 14, 1912, the same day the Titanic struck the iceberg that caused it to sink.
', 1, 2, N'Titanic_1997_film_poster.png', 2, 10)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (23, N'The Notebook', N'Năm 1940, tại một lễ hội ở Đảo Seabrook, Nam Carolina, một công nhân nhà máy gỗ nghèo Noah Calhoun anh ấy đã nhìn thấy một cô gái 17 tuổi Allison "Allie" Hamilton người đang trải quả kỳ nghỉ hè trong thị trấn với cha mẹ cô. Anh ấy đã theo đuổi cô ấy và họ đã bắt đầu một mối tình vào mùa hè năm ấy. Vào một đêm, Allie đi đến nhà của Noah và gặp cha của anh là Frank Calhoun ông ấy ngay lập tức thích Allie và đưa cô tiếp đãi cô như một người thân trong gia đình. Vài ngày sau, Noah được cha mẹ cô là John và Anne Hamilton mời đến nhà nhưng không giống Frank, họ không có ấn tượng gì với Noah. Tối hôm đó, Noah đã đưa cô đến một căn nhà tên là Windsor bị bỏ hoang mà anh định mua và sửa sang lại nó. Khi ở đây, Allie yêu cầu Noah làm tình với cô ấy, nhưng sau đó đã trở nên lo lắng và lan man. Họ bị gián đoạn bởi bởi người bạn của Noah là Fin với tin tức rằng cha mẹ của Allie đã cho cảnh sát tìm cô ấy.', 1, 3, N'Posternotebook.png', 2, 10)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (24, N'Eternal Sunshine of the Spotless Mind
', N'Barish và Clementine Kruczynski quen nhau trong một buổi tiệc trên bãi biển Montauk, New York. Joel để ý tới Clementine vì chiếc áo khoác da cam và mái tóc nhuộm xanh lục của cô. Joel, một người trầm tính, nhút nhát, yêu thích vẽ và viết, nhanh chóng yêu quý Clementine, một cô gái sôi nổi, bốc đồng, thường xuyên thay đổi thuốc nhuộm tóc.', 1, 4, N'Eternal_sunshine_of_the_spotless.png', 2, 10)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (26, N'La La Land
', N'Mia (Emma Stone) là một nữ diễn viên kiêm nhân viên pha chế mang nhiều hoài bão. Trên tuyến đường cao tốc đông đúc vào mùa Đông ở Los Angeles ("Another Day of Sun"), nàng vô tình chạm mặt Sebastian (Ryan Gosling), một nhạc công jazz. Sau khi gặp thất bại ở buổi thử vai, ba cô bạn cùng phòng mời Mia đến một bữa tiệc sang trọng tại Hollywood Hills ("Someone in the Crowd") để khích lệ nàng. Tàn tiệc, Mia biết xe mình bị kéo đi và phải đi bộ về nhà.', 1, 5, N'La_La_Land_film.png', 2, 13)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (27, N'500 Days of Summer
', N'Vào mùng 8 tháng 1, Tom Hansen (Joseph Gordon-Levitt) gặp Summer Finn (Zooey Deschanel), thư ký mới của ông chủ anh. Tom có tay nghề về kiến trúc nhưng lại làm ở một công ty viết thiếp ở Los Angeles. Sau một đêm karaoke, bạn của Tom và đồng nghiệp McKenzie (Geoffrey Arend) phát hiện ra rằng Tom thích Summer. Vài tháng sau Summer và Tom thân thiết hơn, mặc dù Summer đã nói với Tom rằng cô không tin vào tình yêu đích thực, và không muốn có bạn trai.', 1, 6, N'500_Days_of_Summer.png', 2, 14)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (29, N'The Lion King
', N'Nhân vật chính của Vua sư tử là chú sư tử con Simba, con trai của Mufasa, vị vua đang thống trị thế giới hoang dã ở đây. Cuộc sống hạnh phúc yêu đời bên cạnh cha mẹ và cô bạn Nala của cậu sớm chấm dứt khi người chú ruột Scar (mặt sẹo) có âm mưu cướp ngai vàng của cha cậu. Scar đã sắp đặt sẵn một kế hoạch tàn bạo, phối hợp với bầy linh cẩu hoang dàn dựng nên một cuộc chạy trốn tán loạn của vô vàn con linh dương rồi để cho Simba bị mắc kẹt trong đó. Để cứu con trai, vị vua của muôn loài đã phải hi sinh thân mình. Vừa tiêu diệt được đối thủ, vừa gây nên sự ân hận trong người cháu ruột bé nhỏ Simba, Scar đã đạt được mục tiêu của mình. Scar xô Mufasa rơi xuống núi, và nói trước khi Mufasa chết: "Đức vua vạn tuế!". Mufasa rơi khỏi dãy núi và chết vì bị dẫm đạp trong hỗn loạn.', 1, 7, N'The_Lion_King_poster.png', 2, 15)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (30, N'Frozen
', N'Câu chuyện mở đầu với cảnh một nhóm người đang khoét băng thành những tảng nước đá lớn, mang đi bán kiếm tiền. Trong số đó có Kristoff hồi còn nhỏ và chú tuần lộc của mình tên Sven. Cách đó không xa, Elsa là công chúa vương quốc Arendelle, mang trong mình sức mạnh tạo ra băng giá. Một đêm nọ, khi đang chơi đùa, nàng vô tình làm bị thương em gái mình là Anna. Nhà vua và hoàng hậu nhờ tới sự giúp đỡ của đám thạch yêu tinh; và vị trưởng tộc của họ là ông Pabbie lớn, đã chữa lành cho Anna và xoá đi mọi ký ức của nàng về phép thuật của chị gái. ', 4, 2, N'Frozen_2013_film_poster.png', 2, 16)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (31, N'Beauty and the Beast
', N'Lấy bối cảnh nước Pháp thời kỳ Rococo, vào một đêm đông giá rét, một vị hoàng tử tổ chức một buổi dạ hội tại lâu đài của mình, rồi bất chợt một bà lão ăn mày tới và cầu xin chàng đổi một bông hồng lấy một chỗ trú cho bà qua đêm đông. Vị hoàng tử, vì vẻ ngoài xấu xí của bà, đã đuổi bà lão đi, mặc kệ lời cảnh báo của bà về việc đừng bao giờ để bị đánh lừa bởi vẻ bề ngoài. Quay trở lại thân phận thực sự của mình là một phù thủy xinh đẹp, người phụ nữ đã phù phép hoàng tử trở thành một Quái vật khổng lồ và những người hầu của chàng trở thành những đồ dùng trong lâu đài, trước khi xóa ký ức về sự hiện diện của lâu đài của tất cả những người tham dự bữa tiệc. Nữ phù thủy đã bỏ bùa vào bông hồng, và cảnh báo Quái vật rằng, trừ khi chàng học được cách để yêu thương người khác và có được tình yêu của cô gái ấy trước khi cánh hồng cuối cùng rơi xuống, bằng không thì lời nguyền sẽ ở lại với chàng mãi mãi.', 4, 3, N'Người_đẹp_và_quái_vật_poster.png', 2, 17)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (32, N'Tom and Jerry
', N'Loạt phim có nội dung về trận chiến bất tận giữa hai đối thủ truyền kiếp là một chú mèo nhà và một chú chuột nhắt. Hầu hết các tập phim đều tập trung vào mưu đồ bắt chú chuột Jerry của mèo Tom và chuột Jerry với vô vàn kế hoạch tinh vi. Điều thú vị là ít khi chú mèo Tom có ý định bắt giữ chú chuột Jerry để ăn thịt mà thường là do những mâu thuẫn, trách nhiệm "mèo là phải bắt chuột"', 30, 4, N'Titlecard_TJ.png', 2, 18)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (33, N'Home Alone
', N'Tại Chicago, gia đình McCallister dự định sẽ tận hưởng kỳ nghỉ lễ Giáng sinh ở Paris. Cậu bé Kevin lúc này đã 8 tuổi, là con út trong gia đình. Cậu ấy đã xảy ra ẩu đả với anh trai là Buzz chỉ vì miếng bánh Pizza. Kevin bị mẹ la mắng và bị bắt ngủ một mình trên gác cùng với một đứa em họ, cậu nổi giận và ước gì gia đình mình biến mất. Đêm hôm đó bão thổi mạnh làm nhà của gia đình McCallister bị mất điện.', 1, 5, N'Home_alone.png', 2, 19)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (34, N'Matilda
', N'Chán ngán với việc bị đối xử tệ ở nhà và ở trường, một cô bé tài năng sử dụng sức mạnh mới phát hiện để đứng lên bảo vệ bản thân và các bạn cùng lớp.', 1, 6, N'Matilda.png', 2, 20)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (35, N'Jumanji
', N'Câu chuyện xoay quanh một trò chơi hội đồng siêu nhiên giải phóng những mối nguy hiểm từ rừng rậm đối với người chơi sau mỗi lượt chơi của họ. Khi còn là một cậu bé vào năm 1969, Alan Parrish bị mắc kẹt trong chính trò chơi khi chơi với bạn của mình, Sarah Whittle. 26 năm sau, hai chị em ruột Judy và Peter Shepherd tìm thấy trò chơi, bắt đầu chơi và sau đó vô tình thả Alan lúc này đã trưởng thành. Sau khi theo dõi Sarah, bộ tứ quyết định kết thúc trò chơi để đảo ngược tất cả sự tàn phá mà nó đã gây ra.', 2, 7, N'Jumanji_-The_Next_Level_film_pos.png', 2, 21)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (36, N'The Incredibles', N'Gia đình siêu nhân là một bộ phim hoạt hình máy tính thuộc thể loại siêu anh hùng được Pixar Animation Studios sản xuất và hãng Walt Disney Pictures phát hành. Phim được Brad Bird, một cựu đạo diễn và cố vấn điều hành trong chương trình The Simpsons, viết kịch bản và đạo diễn.', 10, 2, N'The_Incredibles_2004_animated_fe.png', 2, 22)
INSERT [dbo].[Movie] ([movie_id], [name], [movie_content], [episodes], [movie_schedule], [image], [country_id], [views]) VALUES (37, N'The Sound of Music
', N'Maria, một cô gái học sinh trở thành một nữ tu tại một tu viện Nonnberg tại Salzburg của Áo. Tuy nhiên cuộc sống trầm lặng ở tu viện lại không phù hợp với cô gái yêu ca hát, hồn nhiên và đôi chút hậu đậu, lơ đãng này. Cô được gửi tới làm gia sư cho 7 đứa trẻ, con của vị đại tá hải quân đã goá vợ Georg Ludwig von Trapp, bao gồm: Liesl (16 tuổi), Friedrich (14 tuổi), Louisa (13), Kurt (11), Brigitta (10), Marta (7) và Gretl (5). Maria nhận ra rằng đại tá Von Trapp đã dạy dỗ và quản lý đứa trẻ theo quân luật một cách quá nghiêm khắc, khiến chúng trở nên bướng bỉnh, mặc dù trước mặt cha thì chúng tỏ vẻ ngoan ngoãn và dễ bảo. Maria quyết định phải dùng tình yêu và âm nhạc để thay đổi chúng. Liesl, đứa con gái lớn của đại tá, lại đem lòng yêu một anh chàng đưa thư tên Rolfe.', 1, 3, N'Sound_of_music.png', 2, 23)
SET IDENTITY_INSERT [dbo].[Movie] OFF
GO
INSERT [dbo].[Movie_Category] ([movie_id], [category_id]) VALUES (7, 1)
INSERT [dbo].[Movie_Category] ([movie_id], [category_id]) VALUES (9, 1)
INSERT [dbo].[Movie_Category] ([movie_id], [category_id]) VALUES (9, 2)
INSERT [dbo].[Movie_Category] ([movie_id], [category_id]) VALUES (9, 3)
INSERT [dbo].[Movie_Category] ([movie_id], [category_id]) VALUES (10, 2)
INSERT [dbo].[Movie_Category] ([movie_id], [category_id]) VALUES (10, 5)
INSERT [dbo].[Movie_Category] ([movie_id], [category_id]) VALUES (13, 3)
INSERT [dbo].[Movie_Category] ([movie_id], [category_id]) VALUES (13, 7)
INSERT [dbo].[Movie_Category] ([movie_id], [category_id]) VALUES (14, 6)
INSERT [dbo].[Movie_Category] ([movie_id], [category_id]) VALUES (15, 6)
GO
INSERT [dbo].[Movie_Company] ([movie_id], [company_id]) VALUES (9, 1)
INSERT [dbo].[Movie_Company] ([movie_id], [company_id]) VALUES (10, 2)
INSERT [dbo].[Movie_Company] ([movie_id], [company_id]) VALUES (13, 3)
INSERT [dbo].[Movie_Company] ([movie_id], [company_id]) VALUES (14, 1)
INSERT [dbo].[Movie_Company] ([movie_id], [company_id]) VALUES (15, 2)
GO
INSERT [dbo].[Movie_Language] ([movie_id], [language_id], [type]) VALUES (9, 1, 0)
INSERT [dbo].[Movie_Language] ([movie_id], [language_id], [type]) VALUES (10, 1, 0)
INSERT [dbo].[Movie_Language] ([movie_id], [language_id], [type]) VALUES (13, 1, 1)
INSERT [dbo].[Movie_Language] ([movie_id], [language_id], [type]) VALUES (14, 1, 0)
INSERT [dbo].[Movie_Language] ([movie_id], [language_id], [type]) VALUES (15, 1, 0)
INSERT [dbo].[Movie_Language] ([movie_id], [language_id], [type]) VALUES (17, 1, 0)
GO
INSERT [dbo].[Movie_Person] ([movie_id], [person_id]) VALUES (9, 2)
INSERT [dbo].[Movie_Person] ([movie_id], [person_id]) VALUES (10, 1)
INSERT [dbo].[Movie_Person] ([movie_id], [person_id]) VALUES (10, 2)
INSERT [dbo].[Movie_Person] ([movie_id], [person_id]) VALUES (13, 2)
INSERT [dbo].[Movie_Person] ([movie_id], [person_id]) VALUES (14, 1)
INSERT [dbo].[Movie_Person] ([movie_id], [person_id]) VALUES (15, 2)
INSERT [dbo].[Movie_Person] ([movie_id], [person_id]) VALUES (18, 5)
GO
SET IDENTITY_INSERT [dbo].[Movie_User] ON 

INSERT [dbo].[Movie_User] ([user_id], [user_name], [password], [name], [email], [role_id], [avatar]) VALUES (1, N'gojo', N'123', N'aaaa', N'abc@gmail.com', 1, N'default.png')
INSERT [dbo].[Movie_User] ([user_id], [user_name], [password], [name], [email], [role_id], [avatar]) VALUES (2, N'a', N'$2a$10$t3SDsd13oA/zQFcwEUhBFe.4spupIt0b5kvQWTbWAgD5.B4w/swPi', N'nguyenvana', N'nguyenvana@gmail.com', 1, N'default.png')
SET IDENTITY_INSERT [dbo].[Movie_User] OFF
GO
SET IDENTITY_INSERT [dbo].[Person] ON 

INSERT [dbo].[Person] ([person_id], [name], [gender], [day_of_birth], [image], [describe], [country_id]) VALUES (1, N'Naruto', 0, CAST(N'2023-09-29T00:00:00.000' AS DateTime), N'naruto.jpg', NULL, 1)
INSERT [dbo].[Person] ([person_id], [name], [gender], [day_of_birth], [image], [describe], [country_id]) VALUES (2, N'Sasuke', 0, CAST(N'2023-09-28T00:00:00.000' AS DateTime), N'sasuke.jpg', N'', 1)
INSERT [dbo].[Person] ([person_id], [name], [gender], [day_of_birth], [image], [describe], [country_id]) VALUES (5, N'Bruce Willis', 0, CAST(N'1955-03-19T00:00:00.000' AS DateTime), N'800px-Bruce_Willis_by_Gage_Skidm.png', N'Willis rời New York và chuyển đến California để thử vai trong một số chương trình truyền hình. Vào năm 1984, ông xuất hiện trong một tập phim của sê-ri truyền hình Miami Vice, với tiêu đề là "No Exit". Năm 1985, ông đóng vai khách mời trong tập "Shatterday" của sê-ri The Twilight Zone.[13] Ông thử vai David Addison Jr. trong sê-ri Moonlighting (1985-1989), và ông đã vượt qua 3000 diễn viên khác để giành được vai này.[14] Vai diễn đối diện với Cybill Shepherd, đã giúp ông trở thành diễn viên hài với chương trình kéo dài năm mùa. Trong thời gian đó, ông đã giành giải Emmy cho Nam diễn viên sê-ri chính kịch xuất sắc nhất và giải Quả cầu vàng cho Nam diễn viên sê-ri hài - nhạc kịch xuất sắc nhất.
', 2)
INSERT [dbo].[Person] ([person_id], [name], [gender], [day_of_birth], [image], [describe], [country_id]) VALUES (6, N'Alan Rickman', 0, CAST(N'1946-02-21T00:00:00.000' AS DateTime), N'220px-Alan_Rickman_BAM_2011-01-1.png', N'Rickman sinh ra ở Nam Hammersmith, Luân Đôn, Anh, trong 1 gia đình công nhân và là con trai của bà Margaret Doreen Rose (Bartlett) và ông Bernard Rickman. Cha của ông là một người Ai Len theo đạo Công giáo và mẹ ông là một người xứ Wales theo Phong trào Giám lý. Gia đình ông có bốn người con bao gồm người anh cả David (sinh năm 1944) làm thiết kế đồ họa, một người em trai Michael (sinh năm 1947) làm huấn luyện viên quần vợt và người em gái út Sheila (sinh năm 1950).
', 2)
INSERT [dbo].[Person] ([person_id], [name], [gender], [day_of_birth], [image], [describe], [country_id]) VALUES (7, N'Tom Hardy', 0, CAST(N'1977-09-15T00:00:00.000' AS DateTime), N'800px-Tom_Hardy_by_Gage_Skidmore.png', N'Hardy sinh ra tại Hammersmith, London,[2] là đứa con duy nhất của Anne (née Barrett) và Edward "Chips" Hardy.[3] Anh lớn lên tại East Sheen, London.[4] Mẹ anh là họa sĩ sinh ra trong gia đình gốc Ireland, [5] còn bố anh viết truyện hài và tiểu thuyết.[6][7] Hardy theo học tại trường Tower House và Reeds, rồi đến trường Richmond Drama, và sau cùng là Drama Centre London.
', 2)
INSERT [dbo].[Person] ([person_id], [name], [gender], [day_of_birth], [image], [describe], [country_id]) VALUES (8, N'Charlize Theron', 1, CAST(N'1975-08-07T00:00:00.000' AS DateTime), N'800px-Charlize-theron-IMG_6045.png', N'Theron sinh tại Cape Town, Nam Phi. Cha cô, ông Charles Theron, chủ nhân của một công ty xây dựng thuộc dòng dõi người Pháp theo Đạo Tin Lành (Huguenot). Mẹ cô, bà Gerda, một người Đức đã tiếp quản công việc kinh doanh của chồng mình sau khi ông qua đời. Ngôn ngữ đầu tiên của Charlize là Afrikaans. Cô còn thông thạo Tiếng Anh và nói được tiếng Xhosa. "Theron" là họ tiếng Pháp của cô (nguyên văn là Théron) phát âm theo tiếng Afrikaans là "Tronn". Nhưng cô nói thích được gọi là "Thrown" hơn. Cách phát âm thường được dùng ở Mỹ bao gồm 2 âm tiết, nhấn mạnh ở âm đầu tiên.
', 2)
INSERT [dbo].[Person] ([person_id], [name], [gender], [day_of_birth], [image], [describe], [country_id]) VALUES (9, N'Christian Bale', 0, CAST(N'1974-01-30T00:00:00.000' AS DateTime), N'800px-Christian_Bale-7837.png', N'Bale sống ở Los Angeles từ những năm 1990. Anh ấy có quốc tịch Hoa Kỳ. Bale kết hôn với Sandra "Sibi" Blažić, một cựu người mẫu, tại Las Vegas vào ngày 29 tháng 1 năm 2000. Cặp đôi có một con gái và một con trai. Năm 2000, Bale trở thành con riêng của nhà nữ quyền Gloria Steinem sau cuộc hôn nhân của bà với cha anh, người đã qua đời năm 2003 vì ung thư hạch não.
', 2)
INSERT [dbo].[Person] ([person_id], [name], [gender], [day_of_birth], [image], [describe], [country_id]) VALUES (10, N'Heath Ledger', 0, CAST(N'1979-04-04T00:00:00.000' AS DateTime), N'1024px-Heath_Ledger.png', N'Ledger sinh ra tại Perth, Tây Australia, con trai của Sally Ledger Bell (née Ramshaw),[3] một giáo viên người Pháp và Kim Ledger, một tay lái xe đua và một kỹ sư khai khoáng.[4] Mẹ của Ledger xuất thân từ dòng họ Campbell của Scotland còn cha anh xuất thân từ một gia đình nổi tiếng ở Perth vì họ là chủ của Ledger Engineering Foundry.[5] Heath (Heathcliff) và em gái của anh Katherine được đặt tên theo tên hai nhân vật chính trong Wuthering Heights của Emily Bronte. Quỹ từ thiện Sir Frank Ledger đã được đặt tên theo cố của anh.[6] Ledger học tiểu học tại Trường tiểu học Marys Mount ở Gooseberry Hill, và sau đó là Trường trung học Guildford và trường dự bị cùng tên.
', 2)
INSERT [dbo].[Person] ([person_id], [name], [gender], [day_of_birth], [image], [describe], [country_id]) VALUES (11, N'Keanu Reeves', 0, CAST(N'1964-09-02T00:00:00.000' AS DateTime), N'800px-Reuniao_com_o_ator_norte-a.png', N'Keanu sinh ngày 2 tháng 9 năm 1964 tại thủ đô Beirut, Liban, là con của bà Patricia Taylor, một nhà thiết kế trang phục và người biểu diễn ở Essex, Vương quốc Anh và ông Samuel Nowlin Reeves Jr. - một nhà địa chất học.[3] Mẹ của anh là người Anh còn cha của anh là một người Hawaii gốc Hoa, có tổ tiên là người Anh, Ireland và Bồ Đào Nha. Trong người anh mang cả ba dòng máu Mỹ - Á - Âu.
', 2)
SET IDENTITY_INSERT [dbo].[Person] OFF
GO
SET IDENTITY_INSERT [dbo].[Role] ON 

INSERT [dbo].[Role] ([role_id], [name]) VALUES (1, N'admin')
SET IDENTITY_INSERT [dbo].[Role] OFF
GO
SET IDENTITY_INSERT [dbo].[Search_Input] ON 

INSERT [dbo].[Search_Input] ([id], [sentence]) VALUES (2, N'hôm nay tôi buồn')
INSERT [dbo].[Search_Input] ([id], [sentence]) VALUES (3, N'hôm nay tôi vui')
INSERT [dbo].[Search_Input] ([id], [sentence]) VALUES (4, N'hôm nay tôi vui')
INSERT [dbo].[Search_Input] ([id], [sentence]) VALUES (5, N'Không có gì tuyệt vời hơn khi được cười vui vẻ cùng phim hài.')
INSERT [dbo].[Search_Input] ([id], [sentence]) VALUES (6, N'xem phim để thấy vui hơn')
SET IDENTITY_INSERT [dbo].[Search_Input] OFF
GO
/****** Object:  Index [IX_Movie_Episode]    Script Date: 07/11/2023 8:04:24 SA ******/
CREATE NONCLUSTERED INDEX [IX_Movie_Episode] ON [dbo].[Episode]
(
	[movie_id] ASC,
	[episode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_username]    Script Date: 07/11/2023 8:04:24 SA ******/
ALTER TABLE [dbo].[Movie_User] ADD  CONSTRAINT [UK_username] UNIQUE NONCLUSTERED 
(
	[user_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Movie] ADD  CONSTRAINT [DF_Movie_views]  DEFAULT ((0)) FOR [views]
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK_Comment_Movie] FOREIGN KEY([movie_id])
REFERENCES [dbo].[Movie] ([movie_id])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK_Comment_Movie]
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK_Comment_Movie_User] FOREIGN KEY([user_id])
REFERENCES [dbo].[Movie_User] ([user_id])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK_Comment_Movie_User]
GO
ALTER TABLE [dbo].[Episode]  WITH CHECK ADD  CONSTRAINT [FK_Episode_Movie] FOREIGN KEY([movie_id])
REFERENCES [dbo].[Movie] ([movie_id])
GO
ALTER TABLE [dbo].[Episode] CHECK CONSTRAINT [FK_Episode_Movie]
GO
ALTER TABLE [dbo].[History]  WITH CHECK ADD  CONSTRAINT [FK_History_Episode] FOREIGN KEY([episode_id])
REFERENCES [dbo].[Episode] ([episode_id])
GO
ALTER TABLE [dbo].[History] CHECK CONSTRAINT [FK_History_Episode]
GO
ALTER TABLE [dbo].[History]  WITH CHECK ADD  CONSTRAINT [FK_History_Movie_User] FOREIGN KEY([user_id])
REFERENCES [dbo].[Movie_User] ([user_id])
GO
ALTER TABLE [dbo].[History] CHECK CONSTRAINT [FK_History_Movie_User]
GO
ALTER TABLE [dbo].[Movie]  WITH CHECK ADD  CONSTRAINT [FK_Movie_Country] FOREIGN KEY([country_id])
REFERENCES [dbo].[Country] ([country_id])
GO
ALTER TABLE [dbo].[Movie] CHECK CONSTRAINT [FK_Movie_Country]
GO
ALTER TABLE [dbo].[Movie_Category]  WITH CHECK ADD  CONSTRAINT [FK_Movie_Category_Category] FOREIGN KEY([category_id])
REFERENCES [dbo].[Category] ([category_id])
GO
ALTER TABLE [dbo].[Movie_Category] CHECK CONSTRAINT [FK_Movie_Category_Category]
GO
ALTER TABLE [dbo].[Movie_Category]  WITH CHECK ADD  CONSTRAINT [FK_Movie_Category_Movie] FOREIGN KEY([movie_id])
REFERENCES [dbo].[Movie] ([movie_id])
GO
ALTER TABLE [dbo].[Movie_Category] CHECK CONSTRAINT [FK_Movie_Category_Movie]
GO
ALTER TABLE [dbo].[Movie_Collection]  WITH CHECK ADD  CONSTRAINT [FK_Movie_Collection_Movie] FOREIGN KEY([movie_id])
REFERENCES [dbo].[Movie] ([movie_id])
GO
ALTER TABLE [dbo].[Movie_Collection] CHECK CONSTRAINT [FK_Movie_Collection_Movie]
GO
ALTER TABLE [dbo].[Movie_Collection]  WITH CHECK ADD  CONSTRAINT [FK_Movie_Collection_User] FOREIGN KEY([user_id])
REFERENCES [dbo].[Movie_User] ([user_id])
GO
ALTER TABLE [dbo].[Movie_Collection] CHECK CONSTRAINT [FK_Movie_Collection_User]
GO
ALTER TABLE [dbo].[Movie_Company]  WITH CHECK ADD  CONSTRAINT [FK_Movie_Company_Company] FOREIGN KEY([company_id])
REFERENCES [dbo].[Company] ([company_id])
GO
ALTER TABLE [dbo].[Movie_Company] CHECK CONSTRAINT [FK_Movie_Company_Company]
GO
ALTER TABLE [dbo].[Movie_Company]  WITH CHECK ADD  CONSTRAINT [FK_Movie_Company_Movie] FOREIGN KEY([movie_id])
REFERENCES [dbo].[Movie] ([movie_id])
GO
ALTER TABLE [dbo].[Movie_Company] CHECK CONSTRAINT [FK_Movie_Company_Movie]
GO
ALTER TABLE [dbo].[Movie_Language]  WITH CHECK ADD  CONSTRAINT [FK_Move_Language_Language] FOREIGN KEY([language_id])
REFERENCES [dbo].[Language] ([language_id])
GO
ALTER TABLE [dbo].[Movie_Language] CHECK CONSTRAINT [FK_Move_Language_Language]
GO
ALTER TABLE [dbo].[Movie_Language]  WITH CHECK ADD  CONSTRAINT [FK_Move_Language_Movie] FOREIGN KEY([movie_id])
REFERENCES [dbo].[Movie] ([movie_id])
GO
ALTER TABLE [dbo].[Movie_Language] CHECK CONSTRAINT [FK_Move_Language_Movie]
GO
ALTER TABLE [dbo].[Movie_Person]  WITH CHECK ADD  CONSTRAINT [FK_Movie_Person_Movie] FOREIGN KEY([movie_id])
REFERENCES [dbo].[Movie] ([movie_id])
GO
ALTER TABLE [dbo].[Movie_Person] CHECK CONSTRAINT [FK_Movie_Person_Movie]
GO
ALTER TABLE [dbo].[Movie_Person]  WITH CHECK ADD  CONSTRAINT [FK_Movie_Person_Person] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([person_id])
GO
ALTER TABLE [dbo].[Movie_Person] CHECK CONSTRAINT [FK_Movie_Person_Person]
GO
ALTER TABLE [dbo].[Movie_User]  WITH CHECK ADD  CONSTRAINT [FK_Movie_User_Role] FOREIGN KEY([role_id])
REFERENCES [dbo].[Role] ([role_id])
GO
ALTER TABLE [dbo].[Movie_User] CHECK CONSTRAINT [FK_Movie_User_Role]
GO
ALTER TABLE [dbo].[Person]  WITH CHECK ADD  CONSTRAINT [FK_Person_Country] FOREIGN KEY([country_id])
REFERENCES [dbo].[Country] ([country_id])
GO
ALTER TABLE [dbo].[Person] CHECK CONSTRAINT [FK_Person_Country]
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [CK_VALUE] CHECK  (([value]>=(1) AND [value]<=(10)))
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [CK_VALUE]
GO
/****** Object:  StoredProcedure [dbo].[Person_id_name]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create Proc [dbo].[Person_id_name]
as
begin
select person_id,name from Person
end

GO
/****** Object:  StoredProcedure [dbo].[SP_ADD_COLLECTION]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_ADD_COLLECTION]
	@user_id INT, @movie_id INT
AS
BEGIN
	INSERT INTO Movie_Collection
	VALUES (@movie_id, @user_id, GETDATE())
	SELECT 1
END


GO
/****** Object:  StoredProcedure [dbo].[SP_ADD_SEARCH_SENTENCE]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_ADD_SEARCH_SENTENCE]
	@sentence nvarchar(500)
AS
BEGIN
	INSERT INTO Search_Input(sentence)
	VALUES (@sentence)
	SELECT 1
END
GO
/****** Object:  StoredProcedure [dbo].[SP_CHECK_EXISTS_COUNTRY]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_CHECK_EXISTS_COUNTRY]
@name nvarchar(50) AS
BEGIN
	IF EXISTS(SELECT 1 FROM Country WHERE name = @name)
		SELECT '1'
	ELSE
		SELECT '0'
END

GO
/****** Object:  StoredProcedure [dbo].[SP_COUNT_COMMENT_MOVIE]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_COUNT_COMMENT_MOVIE]
@id int AS
BEGIN
	SELECT count_cm =COUNT(id_comment) FROM Comment WHERE movie_id = @id
END

GO
/****** Object:  StoredProcedure [dbo].[SP_COUNT_MOVIE_CATEGORY]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_COUNT_MOVIE_CATEGORY]
@category nvarchar(50)
AS
BEGIN
	SELECT COUNT(MC.movie_id) FROM
	(SELECT category_id FROM Category WHERE name = @category) CA INNER JOIN 
	(SELECT category_id, movie_id FROM Movie_Category WITH(INDEX(IX_Category))) MC ON MC.category_id = CA.category_id
END

GO
/****** Object:  StoredProcedure [dbo].[SP_COUNT_PHIM_THEO_2_THE_LOAI]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_COUNT_PHIM_THEO_2_THE_LOAI]
@theloai1 nvarchar(50),@theloai2 nvarchar(50),@theloai3 nvarchar(50),@theloai4 nvarchar(50),@theloai5 nvarchar(50)
AS
BEGIN 
	DECLARE @id_tl1 int, @id_tl2 int, @id_tl3 int, @id_tl4 int, @id_tl5 int
		SELECT @id_tl2 = category_id FROM Category WHERE name = @theloai2
		SELECT @id_tl3 = category_id FROM Category WHERE name = @theloai3
		SELECT @id_tl4 = category_id FROM Category WHERE name = @theloai4
		SELECT @id_tl5 = category_id FROM Category WHERE name = @theloai5
	IF (@theloai1 = '') 
		BEGIN 
			SELECT COUNT(movie_id) FROM  Movie_Category WITH(INDEX(IX_Category))
			WHERE category_id = @id_tl2 OR category_id = @id_tl3 OR category_id = @id_tl4 OR category_id = @id_tl5
		END
	ELSE 
		BEGIN
			SELECT @id_tl1 = category_id FROM Category WHERE name = @theloai1
			SELECT COUNT(M1.movie_id) FROM
			(SELECT movie_id FROM Movie_Category WITH(INDEX(IX_Category)) WHERE  category_id = @id_tl1) M1 
				INNER JOIN (SELECT movie_id FROM Movie_Category WITH(INDEX(IX_Category))
								WHERE category_id = @id_tl2 OR category_id = @id_tl3 OR category_id = @id_tl4 OR category_id = @id_tl5) M2 ON M1.movie_id = M2.movie_id
		END
END

GO
/****** Object:  StoredProcedure [dbo].[SP_COUNT_SEARCH_MOVIE]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_COUNT_SEARCH_MOVIE]
@input nvarchar(100)
AS
BEGIN
	SELECT movie_count=COUNT(M.movie_id) FROM 
		(SELECT movie_id FROM Movie WHERE name LIKE '%'+@input+'%'
		UNION SELECT movie_id = M1.movie_id FROM
			(SELECT person_id FROM Person WHERE name LIKE '%'+@input+'%') P 
			INNER JOIN (SELECT * FROM Movie_Person) MP ON P.person_id = MP.person_id
			INNER JOIN (SELECT movie_id FROM Movie ) M1 ON MP.movie_id = M1.movie_id
		UNION
			SELECT movie_id = M2.movie_id FROM
			(SELECT category_id FROM Category WHERE name LIKE '%'+@input+'%') C 
			INNER JOIN (SELECT * FROM Movie_Category) MC ON C.category_id = MC.category_id
			INNER JOIN (SELECT movie_id FROM Movie) M2 ON MC.movie_id = M2.movie_id
		) M
		
END

GO
/****** Object:  StoredProcedure [dbo].[SP_DELETE_ACTORS]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_DELETE_ACTORS]
@id int AS
BEGIN
	DELETE FROM Person WHERE person_id =@id
	SELECT 1
END

GO
/****** Object:  StoredProcedure [dbo].[SP_DELETE_EPISODE]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_DELETE_EPISODE]
	@movie_id INT, @episode INT
AS
BEGIN
	DECLARE @totalEpisodeNow INT
	DECLARE @episode_id INT
	SELECT @totalEpisodeNow = COUNT(*) FROM Episode WHERE movie_id = @movie_id GROUP BY movie_id

	IF @totalEpisodeNow > 1
	BEGIN
		SELECT @episode_id = episode_id FROM Episode WHERE movie_id = @movie_id AND episode = @episode
		DELETE FROM History WHERE episode_id = @episode_id
		DELETE FROM Episode WHERE episode_id = @episode_id
	END
	ELSE
	BEGIN
		SELECT @episode_id = episode_id FROM Episode WHERE movie_id = @movie_id AND episode = @episode
		DELETE FROM History WHERE episode_id = @episode_id
		DELETE FROM Movie_Person WHERE movie_id = @movie_id
		DELETE FROM Comment WHERE movie_id = @movie_id
		DELETE FROM Movie_Collection WHERE movie_id = @movie_id
		DELETE FROM Movie_Language WHERE movie_id = @movie_id
		DELETE FROM Movie_Company WHERE movie_id = @movie_id
		DELETE FROM Movie_Category WHERE movie_id = @movie_id
		DELETE FROM Episode WHERE movie_id = @movie_id
		DELETE FROM Movie WHERE movie_id = @movie_id
	END
	SELECT 1
END

GO
/****** Object:  StoredProcedure [dbo].[SP_DELETE_HISTORY]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_DELETE_HISTORY]
	@user_id INT, @movie_id INT, @episode INT
AS
BEGIN
	DECLARE @episode_id INT
	SELECT @episode_id = episode_id FROM Episode WHERE movie_id = @movie_id AND episode = @episode
	DELETE FROM History WHERE user_id = @user_id AND episode_id = @episode_id
	SELECT 1
END

GO
/****** Object:  StoredProcedure [dbo].[SP_DELETE_INFORMATION_MOVIE]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_DELETE_INFORMATION_MOVIE]
	@movie_id INT
AS
BEGIN
	BEGIN TRANSACTION; -- Bắt đầu một giao dịch

	BEGIN TRY
		-- Xóa dữ liệu cũ trước đó trước khi cập nhật lại
		DELETE FROM Movie_Category WHERE movie_id = @movie_id;
		DELETE FROM Movie_Company WHERE movie_id = @movie_id;
		DELETE FROM Movie_Language WHERE movie_id = @movie_id;
		DELETE FROM Movie_Person WHERE movie_id = @movie_id;

		COMMIT; -- Lưu các thay đổi vào cơ sở dữ liệu nếu không có lỗi
		SELECT 1;
	END TRY
	BEGIN CATCH
		ROLLBACK; -- Hủy bỏ giao dịch nếu có lỗi
		-- In ra thông báo lỗi hoặc xử lý lỗi tại đây nếu cần
	END CATCH
END;


GO
/****** Object:  StoredProcedure [dbo].[SP_DELETE_MOVIE]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_DELETE_MOVIE]
	@movie_id INT
AS
BEGIN
	DELETE FROM Movie_Person WHERE movie_id = @movie_id
	DELETE FROM Comment WHERE movie_id = @movie_id
	DELETE FROM Movie_Collection WHERE movie_id = @movie_id
	DELETE FROM Movie_Language WHERE movie_id = @movie_id
	DELETE FROM Movie_Company WHERE movie_id = @movie_id
	DELETE FROM Movie_Category WHERE movie_id = @movie_id
	DELETE FROM Movie WHERE movie_id = @movie_id
	SELECT 1
END

GO
/****** Object:  StoredProcedure [dbo].[SP_FIND_COLLECTION]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[SP_FIND_COLLECTION]
@user_id INT
AS
BEGIN
	SELECT MC.movie_id, name, image,views, ISNULL(episode, 0) AS episode, episodes  FROM
	(SELECT user_id, movie_id FROM Movie_Collection WHERE user_id = @user_id) MC INNER JOIN
	(SELECT movie_id, name, image,views, episodes  FROM Movie) M ON MC.movie_id = M.movie_id LEFT JOIN
	(SELECT movie_id, episode = COUNT(*) FROM Episode GROUP BY movie_id) E ON E.movie_id = MC.movie_id
END
GO
/****** Object:  StoredProcedure [dbo].[SP_FIND_COMMENT_MOVIE]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_FIND_COMMENT_MOVIE]
@id int, @start int, @size int 
AS
BEGIN
	SELECT id_comment, C.user_id, name, comment, value, day_cm =  CONVERT(VARCHAR, date, 29), avatar
	FROM (SELECT * FROM Comment WHERE movie_id = @id ) C
		INNER JOIN (SELECT user_id, name,avatar FROM Movie_User) MU ON C.user_id = MU.user_id
	ORDER BY id_comment DESC
	OFFSET (@start) ROWS
	FETCH NEXT (@size) ROWS ONLY;
END

GO
/****** Object:  StoredProcedure [dbo].[SP_FIND_EPISODE_DELETE_MOVIE]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_FIND_EPISODE_DELETE_MOVIE]
	@movie_id INT
AS
BEGIN
	SELECT episode FROM Episode WHERE movie_id = @movie_id
END

GO
/****** Object:  StoredProcedure [dbo].[SP_FIND_HISTORY]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_FIND_HISTORY]
	@user_id INT, @movie_id INT, @episode INT
AS
BEGIN
	IF EXISTS(SELECT * FROM History WHERE user_id = @user_id)
	BEGIN
		DECLARE @episode_id INT
		DECLARE @time INT
		SET @time = 0
		SELECT @episode_id = episode_id FROM Episode WHERE movie_id = @movie_id AND episode = @episode

		SELECT @time = CAST(time_stamp AS INT) FROM History WHERE user_id = @user_id AND episode_id = @episode_id
		SELECT @time
	END
	ELSE SELECT 0
END

GO
/****** Object:  StoredProcedure [dbo].[SP_FIND_MOVIE_CATEGORY]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_FIND_MOVIE_CATEGORY]
@id int
AS
BEGIN
	SELECT name, C.category_id
	FROM (SELECT movie_id,category_id FROM Movie_Category WHERE movie_id = @id) MC
	INNER JOIN (SELECT category_id, name FROM Category) C ON C.category_id = MC.category_id
END

GO
/****** Object:  StoredProcedure [dbo].[SP_FIND_MOVIE_COMPANY]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_FIND_MOVIE_COMPANY]
@id int
AS
BEGIN
	SELECT name, C.company_id
	FROM (SELECT movie_id,company_id FROM Movie_Company WHERE movie_id = @id) MC
	INNER JOIN (SELECT company_id, name FROM Company) C ON C.company_id = MC.company_id 
END

GO
/****** Object:  StoredProcedure [dbo].[SP_FIND_MOVIE_DETAIL]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_FIND_MOVIE_DETAIL]
@id int
AS
BEGIN
	SELECT   M.movie_id, M.name, movie_content, episodes, image, CO.name AS country, views, episode = ISNULL(episode,0), cm_count = ISNULL(c_cm, 0)
		FROM (SELECT movie_id, name, movie_content, episodes, image, country_id, views FROM Movie WHERE movie_id = @id) M 
		LEFT JOIN (SELECT movie_id ,episode = COUNT(episode_id) FROM Episode  WHERE movie_id =@id GROUP BY movie_id) E ON M.movie_id = E.movie_id
		LEFT JOIN (SELECT movie_id , c_cm = COUNT(id_comment)  FROM Comment WHERE movie_id =@id GROUP BY movie_id) C ON M.movie_id = C.movie_id
		INNER JOIN (SELECT country_id, name FROM Country) CO ON M.country_id = CO.country_id 
END

GO
/****** Object:  StoredProcedure [dbo].[SP_FIND_MOVIE_EPISODES]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_FIND_MOVIE_EPISODES]
@id int AS
BEGIN
	SELECT * FROM Episode WITH(INDEX(IX_Movie_Episode)) WHERE movie_id = @id 
END

GO
/****** Object:  StoredProcedure [dbo].[SP_FIND_MOVIE_LANGUAGE]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_FIND_MOVIE_LANGUAGE]
@id int
AS
BEGIN
	SELECT name, type,L.language_id
	FROM (SELECT movie_id,language_id, type FROM Movie_Language WHERE movie_id = @id) ML
	INNER JOIN (SELECT * FROM Language) L ON L.language_id = ML.language_id
END

GO
/****** Object:  StoredProcedure [dbo].[SP_FIND_MOVIE_NEW_COMMENT]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_FIND_MOVIE_NEW_COMMENT]
AS
BEGIN
	SELECT TOP 6 movie_id = M.movie_id, name, views , image,  new_cm = ISNULL(new_cm,0)
	FROM (SELECT movie_id, name, episodes, views, image FROM Movie) M 
	LEFT JOIN (SELECT movie_id ,episode = COUNT(episode_id),episode_id = MAX(episode_id) FROM Episode GROUP BY movie_id) E ON M.movie_id = E.movie_id
	LEFT JOIN (SELECT movie_id , c_cm = COUNT(id_comment), new_cm =MAX(id_comment)  FROM Comment GROUP BY movie_id) C ON M.movie_id = C.movie_id
	ORDER BY new_cm DESC, views DESC;
END

GO
/****** Object:  StoredProcedure [dbo].[SP_FIND_MOVIE_PERSON]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[SP_FIND_MOVIE_PERSON]
@id int
AS
BEGIN
	SELECT name, P.person_id, image
	FROM (SELECT movie_id,person_id FROM Movie_Person WHERE movie_id = @id) MP
	INNER JOIN (SELECT person_id, name, image FROM Person) P ON P.person_id = MP.person_id
END

GO
/****** Object:  StoredProcedure [dbo].[SP_FIND_NEW_MOVIE]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_FIND_NEW_MOVIE]
@start int, @size int 
AS
BEGIN
	SELECT movie_id = M.movie_id, name, episodes, episode=ISNULL(episode,0), views , cm_count = ISNULL(c_cm, 0), 
	 episode_id=ISNULL(episode_id,0), image
	FROM (SELECT movie_id, name, episodes, views, image FROM Movie) M 
	LEFT JOIN (SELECT movie_id ,episode = COUNT(episode_id), episode_id = MAX(episode_id) FROM Episode GROUP BY movie_id) E ON M.movie_id = E.movie_id
	LEFT JOIN (SELECT movie_id , c_cm = COUNT(id_comment)  FROM Comment GROUP BY movie_id) C ON M.movie_id = C.movie_id
	ORDER BY episode_id DESC, views DESC
	OFFSET (@start) ROWS
	FETCH NEXT (@size) ROWS ONLY;

END

GO
/****** Object:  StoredProcedure [dbo].[SP_FIND_TOP_MOVIE_CATEGORY]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_FIND_TOP_MOVIE_CATEGORY]
@start int, @size int, @category nvarchar(50)
AS
BEGIN
	SELECT movie_id = M.movie_id, name, episodes, episode=ISNULL(episode,0), views , cm_count = ISNULL(c_cm, 0), 
	episode_id=ISNULL(episode_id,0), image
	FROM
	(SELECT category_id FROM Category WHERE name = @category) CA INNER JOIN 
	(SELECT category_id, movie_id FROM Movie_Category) MC ON MC.category_id = CA.category_id
	INNER JOIN 
	(SELECT movie_id, name, episodes, views, image FROM Movie) M ON M.movie_id = MC.movie_id
	LEFT JOIN (SELECT movie_id ,episode = COUNT(episode_id),episode_id = MAX(episode_id) FROM Episode GROUP BY movie_id) E ON M.movie_id = E.movie_id
	LEFT JOIN (SELECT movie_id , c_cm = COUNT(id_comment)  FROM Comment GROUP BY movie_id) C ON M.movie_id = C.movie_id
	ORDER BY views DESC, episode_id DESC
	OFFSET (@start) ROWS
	FETCH NEXT (@size) ROWS ONLY;
END

GO
/****** Object:  StoredProcedure [dbo].[SP_FIND_TOP_VIEW_MOVIE]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_FIND_TOP_VIEW_MOVIE]
@start int, @size int
AS
BEGIN
	SELECT movie_id = M.movie_id, name, episodes, episode = ISNULL(episode, 0), views , cm_count = ISNULL(c_cm, 0), 
	episode_id=ISNULL(episode_id,0), image
	FROM (SELECT movie_id, name, episodes, views, image FROM Movie) M 
	LEFT JOIN (SELECT movie_id ,episode = COUNT(episode_id),episode_id = MAX(episode_id) FROM Episode GROUP BY movie_id) E ON M.movie_id = E.movie_id
	LEFT JOIN (SELECT movie_id , c_cm = COUNT(id_comment)  FROM Comment GROUP BY movie_id) C ON M.movie_id = C.movie_id
	ORDER BY views DESC, episode_id DESC
	OFFSET (@start) ROWS
	FETCH NEXT (@size) ROWS ONLY;
END

GO
/****** Object:  StoredProcedure [dbo].[SP_GET_ACTOR]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_GET_ACTOR]
@start int , @size int
AS
BEGIN
	SELECT P.person_id, actor_name = P.name , gender, day_of_birth = convert(varchar, day_of_birth, 29), image , describe, cn_name = C.name , mv_count = ISNULL(mv,0)
		FROM	
		(SELECT * FROM Person) P INNER JOIN
		(SELECT * FROM Country) C ON P.country_id = C.country_id LEFT JOIN
		(SELECT person_id, mv = COUNT(movie_id) FROM Movie_Person GROUP BY person_id) MP ON MP.person_id = P.person_id
		ORDER BY person_id DESC
			OFFSET (@start) ROWS
			FETCH NEXT (@size) ROWS ONLY;
END

GO
/****** Object:  StoredProcedure [dbo].[SP_GET_ACTOR_COUNT]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[SP_GET_ACTOR_COUNT] 
AS
BEGIN
	SELECT ac_count = COUNT(person_id) FROM Person
END

GO
/****** Object:  StoredProcedure [dbo].[SP_GET_ACTOR_INFO]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_GET_ACTOR_INFO]
@id int
AS
BEGIN
	SELECT id = person_id, name_actor = P.name, gender,day_of_birth,image, describe, name_country = C.name  FROM 
	(SELECT * FROM Person WHERE person_id = @id) P INNER JOIN (SELECT * FROM Country) C ON P.country_id = C.country_id
END

GO
/****** Object:  StoredProcedure [dbo].[SP_GET_COUNTRY]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_GET_COUNTRY]
AS
BEGIN
	SELECT name FROM Country
END

GO
/****** Object:  StoredProcedure [dbo].[SP_GET_STATUS_COLLECTION]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_GET_STATUS_COLLECTION]
	@user_id INT, @movie_id INT
AS
BEGIN
	IF EXISTS(SELECT * FROM Movie_Collection MC WHERE MC.user_id = @user_id AND MC.movie_id = @movie_id)
	BEGIN
		SELECT 1
	END
	ELSE
	BEGIN
		SELECT 0
	END
END

GO
/****** Object:  StoredProcedure [dbo].[SP_INSERT_ACTOR]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_INSERT_ACTOR]
@name nvarchar(50), @gender int, @day_of_birth datetime, @image varchar(100), @describe ntext, @name_cn nvarchar(50)
AS
BEGIN
	DECLARE @id_cn int
	SELECT @id_cn = country_id FROM Country WHERE name = @name_cn
	INSERT INTO Person(name, gender, day_of_birth,image,describe,country_id)
		VALUES (@name, @gender, @day_of_birth,@image,@describe,@id_cn)
END

GO
/****** Object:  StoredProcedure [dbo].[SP_INSERT_COMMENT]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_INSERT_COMMENT]
@movie_id int, @user_id int ,@comment ntext, @value int, @date datetime, @result int OUTPUT
AS
BEGIN
	BEGIN TRY
		INSERT INTO Comment(movie_id, user_id, comment,value,date)
		VALUES (@movie_id, @user_id, @comment,@value,@date)
		SET @result = 1;
    END TRY
	BEGIN CATCH
		SET @result = 0; 
    END CATCH
END

GO
/****** Object:  StoredProcedure [dbo].[SP_INSERT_EPISODE]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_INSERT_EPISODE]
@name nvarchar(50), @episode int, @season nvarchar(50),@source varchar(255), @movie_id int, @day_submit datetime
AS
BEGIN
	INSERT INTO Episode(name,episode,season,source,movie_id,day_submit)
		VALUES(@name,@episode,@season,@source,@movie_id,@day_submit)
		SELECT 1
END

GO
/****** Object:  StoredProcedure [dbo].[SP_INSERT_INFORMATION_MOVIE]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_INSERT_INFORMATION_MOVIE]
	@movie_id INT, @person_id INT, @category_id INT, @language_id INT, @company_id INT , @type int
AS
BEGIN
	BEGIN TRANSACTION; -- Bắt đầu một giao dịch

	BEGIN TRY
		-- Thêm thông tin về công ty liên quan đến phim
		IF (@company_id != 0) AND (NOT EXISTS(SELECT * FROM Movie_Company WHERE movie_id = @movie_id AND company_id = @company_id))
		BEGIN
			INSERT INTO Movie_Company
			VALUES (@movie_id, @company_id);
		END

		-- Thêm thông tin về người liên quan đến phim
		IF (@person_id != 0) AND (NOT EXISTS(SELECT * FROM Movie_Person WHERE movie_id = @movie_id AND person_id = @person_id))
		BEGIN
			INSERT INTO Movie_Person
			VALUES (@movie_id, @person_id);
		END

		-- Thêm thông tin về thể loại của phim
		IF (@category_id != 0) AND (NOT EXISTS(SELECT * FROM Movie_Category WHERE movie_id = @movie_id AND category_id = @category_id))
		BEGIN
			INSERT INTO Movie_Category
			VALUES (@movie_id, @category_id);
		END

		-- Thêm thông tin về ngôn ngữ của phim
		IF (@language_id != 0) AND (NOT EXISTS(SELECT * FROM Movie_Language WHERE movie_id = @movie_id AND language_id = @language_id))
		BEGIN
			INSERT INTO Movie_Language
			VALUES (@movie_id, @language_id, @type);
		END

		COMMIT; -- Lưu các thay đổi vào cơ sở dữ liệu nếu không có lỗi
		SELECT 1;
	END TRY
	BEGIN CATCH
		ROLLBACK; -- Hủy bỏ giao dịch nếu có lỗi
		-- In ra thông báo lỗi hoặc xử lý lỗi tại đây nếu cần
	END CATCH
END;


GO
/****** Object:  StoredProcedure [dbo].[SP_REMOVE_COLLECTION]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_REMOVE_COLLECTION]
	@user_id INT, @movie_id INT
AS
BEGIN
	DELETE FROM Movie_Collection
	WHERE user_id = @user_id AND movie_id = @movie_id
	SELECT 1
END


GO
/****** Object:  StoredProcedure [dbo].[SP_SAVE_HISTORY]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_SAVE_HISTORY]
	@user_id INT, @movie_id INT, @episode INT, @time FLOAT
AS
BEGIN
	DECLARE @v INT
	IF @user_id = 0 /*truong hop khong login nhung van xem, chi update view*/
	BEGIN
		IF @time >= 60
		BEGIN
			
			SELECT @v =  views FROM Movie WHERE movie_id = @movie_id
			UPDATE Movie
			SET views = @v + 1
			WHERE movie_id = @movie_id
			SELECT 1
		END
	END
	ELSE
		BEGIN
		DECLARE @episode_id INT
		SELECT @episode_id = episode_id FROM Episode WHERE movie_id = @movie_id AND episode = @episode
		IF @time >= 60
		BEGIN
			IF EXISTS(SELECT * FROM History WHERE user_id = @user_id AND episode_id = @episode_id)
			BEGIN
				DELETE FROM History WHERE user_id = @user_id AND episode_id = @episode_id
				SELECT 1
			END
			ELSE
			BEGIN
				INSERT INTO History
				VALUES(@user_id, @episode_id, @time)
				SELECT @v =  views FROM Movie WHERE movie_id = @movie_id
				UPDATE Movie
				SET views = @v + 1
				WHERE movie_id = @movie_id
				SELECT 1
			END
		END
		SELECT 0
	END
END 
GO
/****** Object:  StoredProcedure [dbo].[SP_SEARCH_MOVIE]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_SEARCH_MOVIE]
@input nvarchar(100), @start int, @size int
AS
BEGIN

	SELECT  movie_id = M.movie_id, name, episodes, episode=ISNULL(episode,0), views , cm_count = ISNULL(c_cm, 0), 
	episode_id = ISNULL(episode_id,0), image
	FROM (SELECT movie_id, name, episodes, views, image FROM Movie WITH(INDEX(IX_Views)) WHERE name LIKE '%'+@input+'%'
		UNION
		SELECT movie_id = M1.movie_id, name, episodes, views, image FROM
			(SELECT person_id FROM Person WHERE name LIKE '%'+@input+'%') P 
			INNER JOIN (SELECT * FROM Movie_Person) MP ON P.person_id = MP.person_id
			INNER JOIN (SELECT movie_id, name, episodes, views, image FROM Movie WITH(INDEX(IX_Views))) M1 ON MP.movie_id = M1.movie_id
		UNION
			SELECT movie_id = M2.movie_id, name, episodes, views, image FROM
			(SELECT category_id FROM Category WHERE name LIKE '%'+@input+'%') C 
			INNER JOIN (SELECT * FROM Movie_Category) MC ON C.category_id = MC.category_id
			INNER JOIN (SELECT movie_id, name, episodes, views, image FROM Movie WITH(INDEX(IX_Views))) M2 ON MC.movie_id = M2.movie_id
		UNION
			SELECT movie_id = M3.movie_id, name, episodes, views, image FROM
			(SELECT country_id FROM Country WHERE name LIKE '%'+@input+'%') Co 
			INNER JOIN (SELECT movie_id, name, episodes, views, image,country_id FROM Movie WITH(INDEX(IX_Views))) M3 ON Co.country_id = M3.country_id
		) M 
	LEFT JOIN (SELECT movie_id ,episode = COUNT(episode_id),episode_id = MAX(episode_id) FROM Episode GROUP BY movie_id) E ON M.movie_id = E.movie_id
	LEFT JOIN (SELECT movie_id , c_cm = COUNT(id_comment)  FROM Comment GROUP BY movie_id) C ON M.movie_id = C.movie_id
	ORDER BY views DESC, episode_id DESC
	OFFSET (@start) ROWS
	FETCH NEXT (@size) ROWS ONLY;
	
END

GO
/****** Object:  StoredProcedure [dbo].[SP_SELECT_LIST_MOVIE]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_SELECT_LIST_MOVIE]
AS
BEGIN
	SELECT M.movie_id, name, image,views, ISNULL(episode, 0) AS episode, episodes  FROM
	(SELECT movie_id, name, image,views, episodes  FROM Movie) M LEFT JOIN
	(SELECT movie_id, episode = COUNT(*) FROM Episode GROUP BY movie_id) E ON E.movie_id = M.movie_id
END

GO
/****** Object:  StoredProcedure [dbo].[SP_TIM_PHIM_THEO_2_THE_LOAI]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_TIM_PHIM_THEO_2_THE_LOAI]
@theloai1 nvarchar(50),@theloai2 nvarchar(50),@theloai3 nvarchar(50),@theloai4 nvarchar(50),@theloai5 nvarchar(50), @start int, @size int
AS
BEGIN
	DECLARE @id_tl1 int, @id_tl2 int, @id_tl3 int, @id_tl4 int, @id_tl5 int
	SELECT @id_tl2 = category_id FROM Category WHERE name = @theloai2
	SELECT @id_tl3 = category_id FROM Category WHERE name = @theloai3
	SELECT @id_tl4 = category_id FROM Category WHERE name = @theloai4
	SELECT @id_tl5 = category_id FROM Category WHERE name = @theloai5

	IF (@theloai1 = '') 
		BEGIN
			SELECT @id_tl1 = category_id FROM Category WHERE name = @theloai1

			SELECT movie_id = M.movie_id, name, episodes, episode=ISNULL(episode,0), views , cm_count = ISNULL(c_cm, 0), 
			episode_id=ISNULL(episode_id,0), image
			FROM
			 (SELECT movie_id FROM Movie_Category WITH(INDEX(IX_Category))
				WHERE category_id = @id_tl2 OR category_id = @id_tl3 OR category_id = @id_tl4 OR category_id = @id_tl5) M2 
			INNER JOIN (SELECT movie_id, name, episodes, views, image FROM Movie) M ON M.movie_id = M2.movie_id
			LEFT JOIN (SELECT movie_id ,episode = COUNT(episode_id),episode_id = MAX(episode_id) FROM Episode GROUP BY movie_id) E ON M.movie_id = E.movie_id
			LEFT JOIN (SELECT movie_id , c_cm = COUNT(id_comment)  FROM Comment GROUP BY movie_id) C ON M.movie_id = C.movie_id
			ORDER BY views DESC, episode_id DESC
			OFFSET (@start) ROWS
			FETCH NEXT (@size) ROWS ONLY;
		END
	ELSE
	BEGIN
		SELECT @id_tl1 = category_id FROM Category WHERE name = @theloai1

		SELECT movie_id = M.movie_id, name, episodes, episode=ISNULL(episode,0), views , cm_count = ISNULL(c_cm, 0), 
		episode_id=ISNULL(episode_id,0), image
		FROM
		(SELECT movie_id FROM Movie_Category WITH(INDEX(IX_Category)) WHERE  category_id = @id_tl1) M1 
		INNER JOIN (SELECT movie_id FROM Movie_Category WITH(INDEX(IX_Category))
			WHERE category_id = @id_tl2 OR category_id = @id_tl3 OR category_id = @id_tl4 OR category_id = @id_tl5) M2 ON M1.movie_id = M2.movie_id 
		INNER JOIN (SELECT movie_id, name, episodes, views, image FROM Movie) M ON M.movie_id = M2.movie_id
		LEFT JOIN (SELECT movie_id ,episode = COUNT(episode_id),episode_id = MAX(episode_id) FROM Episode GROUP BY movie_id) E ON M.movie_id = E.movie_id
		LEFT JOIN (SELECT movie_id , c_cm = COUNT(id_comment)  FROM Comment GROUP BY movie_id) C ON M.movie_id = C.movie_id
		ORDER BY views DESC, episode_id DESC
		OFFSET (@start) ROWS
		FETCH NEXT (@size) ROWS ONLY;
	END
	
END

GO
/****** Object:  StoredProcedure [dbo].[SP_UPDATE_ACTOR_INFO]    Script Date: 07/11/2023 8:04:24 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_UPDATE_ACTOR_INFO]
@id int, @name nvarchar(50), @gender int , @day datetime, @image varchar(100), @describe ntext, @name_cn nvarchar(50) , @result int OUTPUT
AS
BEGIN
	

	BEGIN TRY
		DECLARE @id_cn int
		SELECT @id_cn = country_id FROM Country WHERE name = @name_cn
		UPDATE Person
		SET name = @name, gender = @gender, day_of_birth = @day, image = @image, describe =@describe, country_id = @id_cn
		WHERE person_id = @id
		SET @result = 1;
    END TRY
	BEGIN CATCH
		SET @result = 0; 
    END CATCH
END

GO

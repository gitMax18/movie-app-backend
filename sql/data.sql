-- Active: 1682854723119@@127.0.0.1@3306@movie_app

INSERT INTO
    content (
        title,
        resume,
        short_resume,
        release_year,
        type
    )
VALUES (
        "Matrix 1",
        "Matrix ou La Matrice au Canada francophone (The Matrix en anglais) est un film de science-fiction1 de type « cyberfilm »2 australo-américain écrit et réalisé par les Wachowski et sorti en 1999. Il dépeint un futur dystopique dans lequel la réalité perçue par la plupart des humains est une simulation virtuelle en se connectant à la « Matrice », créée par des machines douées d'intelligence, afin d'asservir les êtres humains, à leur insu, et de se servir de la chaleur et de l'activité électrique de leur corps comme source d'énergie. Le programmeur informatique Neo apprend cette vérité et rejoint une rébellion.",
        "Matrix ou La Matrice au Canada francophone (The Matrix en anglais) est un film de science-fiction1 de type « cyberfilm »2 australo-américain écrit et réalisé par les Wachowski et sorti en 1999.",
        1999,
        "MOVIE"
    ), (
        "Naruto",
        "Naruto est un shōnen manga écrit et dessiné par Masashi Kishimoto. Naruto a été prépublié dans l'hebdomadaire Weekly Shōnen Jump de l'éditeur Shūeisha entre septembre 1999 et novembre 2014. La série a été compilée en 72 tomes. La version française du manga est publiée par Kana entre mars 2002 et novembre 2016.",
        "Naruto est un shōnen manga écrit et dessiné par Masashi Kishimoto.",
        1999,
        "ANIME"
    );

INSERT INTO category (name)
VALUES ("Adult"), ("Banger"), ("Child"), ("Fiction");

INSERT INTO
    content_category (content_id, category_id)
VALUES (1, 1), (1, 2), (1, 4), (2, 2), (2, 3);
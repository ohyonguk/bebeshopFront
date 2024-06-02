let btn = document.querySelector(".btn");
        let search = document.querySelector(".search");

        let cls = document.querySelector(".fa");
        let header = document.querySelector("#header");

        btn.addEventListener('click', () => {
            if (search.classList.contains("active")) {
                search.classList.remove("active")
            } else {
                search.classList.add("active")
            }
        });

        cls.addEventListener('click', () => {
            search.classList.remove("active")
        });

        document.addEventListener('scroll', () => {
            let currentScrollValue = document.documentElement.scrollTop;
            if (currentScrollValue > 100) {
                header.animate({ opacity: "0" }, 500)
                header.animate({ opacity: "1" }, 500)
            }
        });
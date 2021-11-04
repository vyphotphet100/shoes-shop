$(document).ready(function() {
    $("#header").before(`
<nav style="background-color: whitesmoke; padding: 15px 0;" class="sticky-top">
            <div class="nav__container row">
                <div class="input-group col">
                    <button type="button" id="sidebarCollapse" class="btn btn-info">
                        <i class="fas fa-align-justify"></i>
                    </button>
                    <span style="width: 40px"></span>
                    <span class="input-group-text" id="basic-addon1"><i class="fas fa-search"></i></span>
                    <input type="text" class="form-control" placeholder="Search everything you need!">
                </div>
                <div class="btn__group col">
                    <div class="dropdown float-end">
                        <button class="btn btn-outline-secondary" type="button" id="dropdownMenuButton1"
                                data-bs-toggle="dropdown" aria-expanded="false">
                                <span>
                                    <img style="height: 20px; width: 20px;"
                                         src="https://scontent.fdad2-1.fna.fbcdn.net/v/t1.6435-9/171619300_1092543814590800_1632394128569325001_n.jpg?_nc_cat=108&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=P560_w3_4aMAX83vWZW&_nc_ht=scontent.fdad2-1.fna&oh=5b8190fd275affaaf37019f3cd0b206a&oe=61A3FFE8"
                                         alt="">
                                </span>
                            Username here!
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                            <li><a class="dropdown-item" href="#">Profile</a></li>
                            <li><a class="dropdown-item" href="#">Settings</a></li>
                            <li><a class="dropdown-item" href="#">Sign Out</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>

    `)
})
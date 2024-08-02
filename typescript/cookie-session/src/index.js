import express from "express";
import cookieParser from "cookie-parser";
import session from "express-session";

const app = express();

app.use(express.json());
app.use(cookieParser());
app.use(session({
    secret: "this is secret",
    saveUninitialized: false,
    resave: false,
    cookie: {
        maxAge: 60000,
    },
}));

const PORT = process.env.PORT || 3000;

app.listen(PORT, () => {
    console.log(`Running on PORT ${PORT}`);
});

app.get("/cookie", (request, response) => {
    response.cookie("name", "hi", {
        maxAge: 60000,
    });
    response.status(200).send({msg: "cookie response"});
});

app.get("/cookie-check", (request, response) => {
    console.log(request.headers.cookie);
    console.log(request.cookies);

    if (request.cookies.name && request.cookies.name === "hi") {
        return response.status(200).send({msg: "valid cookie"});
    }

    return response.status(200).send({msg: "invalid cookie"});
});

app.get("/session", (request, response) => {
    console.log(request.session);
    console.log(request.session.id);
    request.session.test = true;

    response.status(200).send({msg: "OK"});
});

app.get("/session-check", (request, response) => {
    // console.log(request.session);
    // console.log(request.session.id);
    request.sessionStore.get(request.session.id, (err, sessionData) => {
            console.log(sessionData);
        },
    );

    response.status(200).send({msg: "OK"});
})
;

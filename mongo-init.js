db.createUser(
        {
            user: "root",
            pwd: "password",
            roles: [
                {
                    role: "readWrite",
                    db: "shares"
                }
            ]
        }
);
db.createCollection('share');

function randomNumber(min, max) {
    return Math.round((Math.random() * (max - min) + min)*100)/100;
}
function randomDate(start, end) {
  var ranDate = new Date(start.getTime() + Math.random() * (end.getTime() - start.getTime()));
  return ranDate.toISOString()
}

var now = new Date();

var sevenDaysAgo = new Date();
sevenDaysAgo.setDate(now.getDate()-7);
var twoDaysAgo = new Date();
twoDaysAgo.setDate(now.getDate()-2);
var fiveHoursAgo = new Date();
fiveHoursAgo.setHours(now.getHours()-5)

n=0;
while(n<9){
    var generatedLast24Hours= randomDate(fiveHoursAgo, now);
    var generatedLast2Days= randomDate(twoDaysAgo, now);
    var generatedLast7Days = randomDate(sevenDaysAgo, twoDaysAgo);
    insert(randomNumber(1,500), generatedLast24Hours)
    insert(randomNumber(1,500), generatedLast2Days)
    insert(randomNumber(1,500), generatedLast7Days)
    n++;
}


function insert(price, generatedDate){
    db.share.insertMany([
    {
        "companyInfo" : {
            "companyId" : "CS.PA",
            "companyName" : "AXA Insurance S.A"
        },
        "price" : price,
        "creationDate" : generatedDate,
        "_class" : "com.apolit.shares.domain.model.Share"
    },
    {
        "companyInfo" : {
            "companyId" : "4F0N",
            "companyName" : "4Finance S.A"
        },
        "price" : price,
        "creationDate" : generatedDate,
        "_class" : "com.apolit.shares.domain.model.Share"
    },
    {
        "companyInfo" : {
            "companyId" : "WABI",
            "companyName" : "Wabi Project"
        },
        "price" : price,
        "creationDate" : generatedDate,
        "_class" : "com.apolit.shares.domain.model.Share"
    },
    {
        "companyInfo" : {
            "companyId" : "DAC",
            "companyName" : "Electric Automation"
        },
        "price" : price,
        "creationDate" : generatedDate,
        "_class" : "com.apolit.shares.domain.model.Share"
    }
    ]);
}
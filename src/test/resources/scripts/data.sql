SET REFERENTIAL_INTEGRITY FALSE
TRUNCATE TABLE "Weather" RESTART IDENTITY
TRUNCATE TABLE "City" RESTART IDENTITY
TRUNCATE TABLE "Country" RESTART IDENTITY
TRUNCATE TABLE "User" RESTART IDENTITY
SET REFERENTIAL_INTEGRITY TRUE
INSERT INTO "User"("userId", "firstName", "lastName", username, password, phone, "emailId", "emailVerified", "createdOn") VALUES (1,'Carlos','Zegarra','cgzegarra','$2a$10$IUu6Lb7yXwTU4fD.jWVQwuIXce.74YoyCeIJdqbIxedgT4anxi5XC','6471234567','cgzegarra@gmail.com',true,'2023-06-12')
ALTER TABLE "User" ALTER COLUMN "userId" RESTART WITH 2
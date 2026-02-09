// import type { Metadata } from "next";
// import { Geist, Geist_Mono } from "next/font/google";
// import "./globals.css";

import { Metadata } from "next";

import "./globals.css";

export const metadata: Metadata = {
  title: "MSC Thesis UI",
  description: "Simple sample Next.js app",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body>{children}</body>
    </html>
  );
}